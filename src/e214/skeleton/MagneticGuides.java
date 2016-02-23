package e214.skeleton ;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JFrame;

import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.CRectangle;
import fr.lri.swingstates.canvas.CSegment;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.canvas.transitions.DragOnTag;
import fr.lri.swingstates.canvas.transitions.PressOnTag;
import fr.lri.swingstates.canvas.transitions.ReleaseOnTag;
import fr.lri.swingstates.sm.State;
import fr.lri.swingstates.sm.Transition;
import fr.lri.swingstates.sm.transitions.Press;
import fr.lri.swingstates.sm.transitions.Release;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 *
 */
public class MagneticGuides extends JFrame {

    private Canvas canvas ;
    private CExtensionalTag oTag ;
    private CExtensionalTag STag ;

    public MagneticGuides(String title, int width, int height) {
	   super(title) ;
	   canvas = new Canvas(width, height) ;
	   canvas.setAntialiased(true) ;
	   getContentPane().add(canvas) ;

	   oTag = new CExtensionalTag(canvas) {} ;
	   STag = new CExtensionalTag(canvas) {} ;

	   CStateMachine sm = new CStateMachine() {

			 private Point2D p ;
			 private CShape draggedShape ;

			 public State start = new State() {
				    Transition pressOnObject = new PressOnTag(oTag, BUTTON1, ">> oDrag") {
						  public void action() {
							 p = getPoint() ;
							 draggedShape = getShape() ;
							 draggedShape.aboveAll();
						  }
					 };
					 
					 Transition pressOnGuide = new PressOnTag(STag, BUTTON1, ">> oDrag") {
						  public void action() {
							 p = getPoint() ;
							 draggedShape = getShape() ;
						  }
					 };
					   
					 Transition click = new Press() {
    					public void action() {
    						p = getPoint();
    						new MagneticGuide(canvas, p);
    					}
    				};
				} ;

			 public State oDrag = new State() {
				    Transition drag = new DragOnTag(oTag, BUTTON1) {
						  public void action() {
							 Point2D q = getPoint() ;
							 draggedShape.translateBy(q.getX() - p.getX(), q.getY() - p.getY()) ;
							 p = q ;
							 Point2D shapeCenter = getShapeCenter(draggedShape);
							 List<CShape> guides = canvas.pickAll(shapeCenter);
							 if (!guides.isEmpty())
								 r;
						  }
				   } ;
				   
				   Transition Gdrag = new DragOnTag(STag, BUTTON1) {
						  public void action() {
							 Point2D q = getPoint() ;
							 draggedShape.translateBy(0, q.getY() - p.getY()) ;
							 p = q ;
						  }
				   } ;
				   
				   Transition release = new Release(BUTTON1, ">> start") {} ;
				    
				    Transition releaseOnGuide = new ReleaseOnTag(STag, BUTTON1, ">>start") {
				    	public void action(){
				    		draggedShape.addTag(STag);
				    	}				    	
				    };
				} ;

		  } ;
	   sm.attachTo(canvas);

	   pack() ;
	   setVisible(true) ;
	   canvas.requestFocusInWindow() ;
    }

    public void populate() {
	   int width = canvas.getWidth() ;
	   int height = canvas.getHeight() ;

	   double s = (Math.random()/2.0+0.5)*30.0 ;
	   double x = s + Math.random()*(width-2*s) ;
	   double y = s + Math.random()*(height-2*s) ;

	   int red = (int)((0.8+Math.random()*0.2)*255) ;
	   int green = (int)((0.8+Math.random()*0.2)*255) ;
	   int blue = (int)((0.8+Math.random()*0.2)*255) ;

	   CRectangle r = canvas.newRectangle(x,y,s,s) ;
	   r.setFillPaint(new Color(red, green, blue)) ;
	   r.addTag(oTag) ;
    }
    
    public Point2D getShapeCenter(CShape shape) {
    	return new Point2D.Double(shape.getCenterX(), shape.getCenterY());
    }

    public static void main(String[] args) {
	   MagneticGuides guides = new MagneticGuides("Magnetic guides",600,600) ;
	   for (int i=0; i<20; ++i) guides.populate() ;
	   guides.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
    }
    
    public class MagneticGuide extends CExtensionalTag {
    	
    	CSegment seg;
    	
    	public MagneticGuide(Canvas canva, Point2D p) {
    		seg = canva.newSegment(0.0, p.getY(), 2000.0, p.getY());
    		seg.addTag(STag);
    	}
    	
    }

}
