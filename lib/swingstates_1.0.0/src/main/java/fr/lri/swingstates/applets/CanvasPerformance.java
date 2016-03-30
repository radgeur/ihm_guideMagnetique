package fr.lri.swingstates.applets;

import java.awt.Dimension;
import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;

import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.canvas.transitions.PressOnShape;
import fr.lri.swingstates.sm.State;
import fr.lri.swingstates.sm.Transition;
import fr.lri.swingstates.sm.transitions.Drag;
import fr.lri.swingstates.sm.transitions.Release;

public class CanvasPerformance extends BasicApplet {

	CShape getShape(Canvas canvas, int width, int height) {
		CShape res = null;
		// CImage, CText, CRectangle, CEllipse, CSegment, CPolyline
		int type = Math.min(5, (int) (Math.random() * 6));
		switch (type) {
		case 0:
			String location =  "images/star.jpg";
			try {
				URL url = new URL(getCodeBase(),location);
				res = canvas.newImage (0, 0, url);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			break;
		case 1:
			Font font = new Font("verdana", Font.PLAIN, 24);
			res = canvas.newText(0, 0, "Hello", font);
			break;
		case 2:
			res = canvas.newRectangle (0, 0, 50, 20);
			break;
		case 3:
			res = canvas.newEllipse (0, 0, 50, 20);
			break;
		case 4:
			res = canvas.newSegment(0, 0, 50, 20);
			break;
		case 5:
			res = canvas.newPolyLine(400, 300).
			lineTo(440, 290).lineTo(450, 250).lineTo(460, 290).lineTo(500, 300).
			lineTo(460, 310).lineTo(450, 350).lineTo(440, 310).close();
			break;
		default:
			break;
		}
		res.translateTo((Math.random() * width), (int) (Math.random() * height));
		
//		// transparency fill/outline
//		float transparency = (float) Math.random();
//		if(Math.random() > 0.5)
//			res.setTransparencyFill(transparency);
//		transparency = (float) Math.random();
//		if(Math.random() > 0.5)
//			res.setTransparencyOutline(transparency);
//		// paint fill/outline
//		int r = (int) (Math.random() * 254);
//		int g = (int) (Math.random() * 254);
//		int b = (int) (Math.random() * 254);
//		res.setFillPaint(new Color(r, g, b));
//		r = (int) (Math.random() * 254);
//		g = (int) (Math.random() * 254);
//		b = (int) (Math.random() * 254);
//		res.setOutlinePaint(new Color(r, g, b));
//		// stroke
//		int w = (int) Math.max(1, Math.random() * 4);
//		res.setStroke(new BasicStroke(w));
		
		return res;
	}
	
	void interaction(Canvas canvas) {
		CStateMachine machine = new CStateMachine(canvas) {
			CShape moved;
			State start = new State() {
				Transition press = new PressOnShape(BUTTON1, ">> move") {
					public void action() {
						moved = getShape();
					}
				};
			};
			State move = new State() {
				Transition move = new Drag(BUTTON1) {
					public void action() {
						moved.translateTo(getPoint().getX(), getPoint().getY());
					}
				};
				Transition stop = new Release(BUTTON1, ">> start") {
					public void action() {
						moved.translateTo(getPoint().getX(), getPoint().getY());
					}
				};
			};
		};
	}
	
	public void createGUI() {
		setSize(new Dimension(800, 600));
		Canvas canvas = new Canvas(800, 600);
		for(int i = 0; i < 5000; i++) {
			getShape(canvas, 800, 600);
		}
		interaction(canvas);
		add(canvas);
	}
	
	
}
