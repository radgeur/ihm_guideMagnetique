/*  
 *   Authors: Caroline Appert (caroline.appert@lri.fr)
 *   Copyright (c) Universite Paris-Sud XI, 2007. All Rights Reserved
 *   Licensed under the GNU LGPL. For full terms see the file COPYING.
*/
package fr.lri.swingstates.gestures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.event.EventListenerList;

import fr.lri.swingstates.canvas.CEllipse;
import fr.lri.swingstates.canvas.CPolyLine;
import fr.lri.swingstates.canvas.CRectangle;
import fr.lri.swingstates.canvas.Canvas;

/**
 * The base class for a gesture classifier.
 * 
 * @author Caroline Appert
 */
public abstract class AbstractClassifier {

	protected int  minimumStrokeLength = 20;
	
	protected ArrayList<String>          classesNames = new ArrayList<String>();
	protected ArrayList<Vector<Point2D>> templates = new ArrayList<Vector<Point2D>>();

	protected abstract Object read(DataInputStream in) throws IOException;

	protected abstract void write(DataOutputStream out) throws IOException;

	private EventListenerList classifierListeners = null;

	protected double[][] distances = new double[50][50];
	
	public AbstractClassifier() {
		invalidateAllDistances();
	}
	
	
	protected void invalidateAllDistances() {
		for(int i = 0; i < distances.length; i++) {
			for(int j = 0; j < distances[0].length; j++) {
				distances[i][j] = Double.NaN;
			}
		}
	}
	
	protected void invalidateDistance(String className) {
		int index = classesNames.indexOf(className);
		for(int i = 0; i < distances.length; i++) {
			distances[i][index] = Double.NaN;
		}
		for(int i = 0; i < distances[0].length; i++) {
			distances[index][i] = Double.NaN;
		}
	}
	
	protected void invalidateDistance(String className1, String className2) {
		int index1 = classesNames.indexOf(className1);
		int index2 = classesNames.indexOf(className2);
			distances[index2][index1] = Double.NaN;
			distances[index1][index2] = Double.NaN;
	}
	
	public synchronized void addClassifierListener(ClassifierListener l) {
		if(l == null) return;
		if(classifierListeners == null) classifierListeners = new EventListenerList();
		classifierListeners.add(ClassifierListener.class, l);
	}
	
	public synchronized void removeClassifierListener(ClassifierListener l) {
		if(l == null || classifierListeners == null) return;
		classifierListeners.remove(ClassifierListener.class, l);
	}
	
	public void fireClassAdded(String className) {
		if(classifierListeners == null) return;
		Object[] tabListeners = classifierListeners.getListenerList();
	     for (int i = tabListeners.length-2; i>=0; i-=2)
	         if (tabListeners[i]==ClassifierListener.class)
	             ((ClassifierListener)tabListeners[i+1]).classAdded(className);
	}
	
	public void fireClassRemoved(String className) {
		if(classifierListeners == null) return;
		Object[] tabListeners = classifierListeners.getListenerList();
	     for (int i = tabListeners.length-2; i>=0; i-=2)
	         if (tabListeners[i]==ClassifierListener.class)
	             ((ClassifierListener)tabListeners[i+1]).classRemoved(className);
	}
	
	public void fireExampleAdded(String className, Gesture example) {
		if(classifierListeners == null) return;
		Object[] tabListeners = classifierListeners.getListenerList();
	     for (int i = tabListeners.length-2; i>=0; i-=2)
	         if (tabListeners[i]==ClassifierListener.class)
	             ((ClassifierListener)tabListeners[i+1]).exampleAdded(className, example);
	}
	
	public void fireExampleRemoved(String className, Gesture example) {
		if(classifierListeners == null) return;
		Object[] tabListeners = classifierListeners.getListenerList();
	     for (int i = tabListeners.length-2; i>=0; i-=2)
	         if (tabListeners[i]==ClassifierListener.class)
	             ((ClassifierListener)tabListeners[i+1]).exampleRemoved(className, example);
	}
	
	public void fireTemplateSet(String className, Vector<Point2D> template) {
		if(classifierListeners == null) return;
		Object[] tabListeners = classifierListeners.getListenerList();
	     for (int i = tabListeners.length-2; i>=0; i-=2)
	         if (tabListeners[i]==ClassifierListener.class)
	             ((ClassifierListener)tabListeners[i+1]).templateSet(className, template);
	}
	
	/**
	 * Removes a gesture example from this classifier.
	 * 
	 * @param gesture
	 *            the gesture to remove
	 */
	public abstract void removeExample(Gesture gesture) throws UnsupportedOperationException;

	/**
	 * Returns a graphical representation for a given class of gestures. The
	 * graphical representation is the one which minimizes the distance with
	 * vector of features characterizing this gesture class.
	 * 
	 * @param className
	 *            the name of the gesture class.
	 * @return A representative polyline for the gesture class having name
	 *         <code>className</code>.
	 */
	public CPolyLine getRepresentative(String className) {
		Vector<Point2D> template = getTemplate(className);
		CPolyLine polyline = new CPolyLine(template.firstElement());
		Iterator<Point2D> iterator = template.iterator();
		iterator.next();
		while(iterator.hasNext())
			polyline.lineTo(iterator.next());
		return polyline;
	}

	/**
	 * Adds a class of gestures to this classifier.
	 * 
	 * @param className
	 *            The name of the class of gestures to add.
	 * @return the index of this class in the list of classes (-1 if this class already exists and thus has not been added).
	 */
	public int addClass(String className) {
		classesNames.add(className);
		templates.add(null);
		if(classesNames.size() > distances.length) {
			double[][] tmp = new double[2*distances.length][2*distances.length];
			for (int i = 0; i < distances.length; i++) {
				for (int j = 0; j < distances[0].length; j++) {
					tmp[i][j] = distances[i][j];
				}
			}
			distances = tmp;
		}
		invalidateDistance(className);
		return classesNames.size() - 1;
	}

	/**
	 * Adds a gesture example to this classifier.
	 * 
	 * @param className
	 *            the gesture example's class
	 * @param example
	 *            the gesture example
	 */
	public abstract void addExample(String className, Gesture example) throws UnsupportedOperationException;
	
	/**
	 * Returns the vector of gesture examples for a given class.
	 * @param className The name of the class
	 * @return The set of examples for the class <code>className</code>.
	 * @throws UnsupportedOperationException
	 */
	public abstract Vector<Gesture> getExamples(String className) throws UnsupportedOperationException;

	/**
	 * Removes a class of gestures from this classifier.
	 * 
	 * @param className
	 *            The name of the class of gestures to remove.
	 */
	public void removeClass(String className) {
		invalidateDistance(className);
		int index = classesNames.indexOf(className);
		if (index != -1) {
			classesNames.remove(index);
			templates.remove(index);
		}
	}

	/**
	 * Renames a class of gestures.
	 * 
	 * @param previousClassName
	 *            The current name of this class of gestures
	 * @param newClassName
	 *            The new name of this class of gestures
	 */
	public void renameClass(String previousClassName, String newClassName) {
		int index = classesNames.indexOf(previousClassName);
		invalidateDistance(previousClassName);
		classesNames.set(index, newClassName);
	}

	/**
	 * Recognizes a gesture.
	 * 
	 * @param g
	 *            The gesture to recognize
	 * @return The name of the class of gestures that best fit to g.
	 */
	public abstract String classify(Gesture g) throws Exception;

	/**
	 * Computes a sorted list of classes contained in this recognizer from the
	 * best match to the the worst match given a gesture.
	 * 
	 * @param g
	 *            The gesture
	 * @return a vector of scores for all the classes registered in this classifier 
	 * 			sorted from the best match (index 0) to the worst match (index n-1),
	 * 			with n the number of classes.
	 * 			A score is a couple (class_name, distance).
	 */
	public abstract Vector<Score> sortedClasses(Gesture g);

	/**
	 * Saves the definition of this classifier in a file.
	 * 
	 * @param filename
	 *            The name of the file where to write the definition of the
	 *            classifier.
	 */
	public void save(File filename) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(filename));
			write(dos);
			dos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Resets this classifier (i.e. removes all the classes of gestures).
	 */
	public void reset() {
		invalidateAllDistances();
		classesNames.clear();
		templates.clear();
	}
	
	/**
	 * Sets the template gesture for a given existing class of gestures in this classifier.
	 * @param className the name of the class of gestures.
	 * @param template the template for the class className.
	 */
	public void setTemplate(String className, Vector<Point2D> template) {
		int index = classesNames.indexOf(className);
		invalidateDistance(className);
		if(index == -1) return;
		templates.remove(index);
		templates.add(index, template);
		fireTemplateSet(className, template);
	}

	/**
	 * @param className the name of the class of gestures.
	 * @return the template for the class className if it exists, null otherwise.
	 */
	public Vector<Point2D> getTemplate(String className) {
		int index = classesNames.indexOf(className);
		if (index == -1) {
			System.err.println("no class " + className + " in the classifier");
			return null;
		}
		return templates.get(index);
	}
	
	/**
	 * @return The list of gesture class names in this classifier.
	 */
	public ArrayList<String> getClassesNames() {
		return classesNames;
	}

	/**
	 * @return The list of templates in this classifier (in the order corresponding to the classes names order returned by <code>getClassesNames</code>).
	 */
	public ArrayList<Vector<Point2D>> getTemplates() {
		return templates;
	}
	
	/**
	 * Creates a squared png image of a stroke given its command name. The stroke is colored in black and its starting point in red.
	 * @param file The image file
	 * @param command The name of the command activated by the stroke
	 * @param sideSizeImage The size of image side
	 * @param sizeStartingPoint The diameter of the stroke's starting point
	 */
	public void getPngImage(File file, String command, int sideSizeImage, int sizeStartingPoint) {
		getPngImage(file, command, sideSizeImage, Color.BLACK, sizeStartingPoint, Color.RED);
	}
	
	/**
	 * Creates a squared png image of a stroke given its command name.
	 * @param file The image file
	 * @param command The name of the command activated by the stroke
	 * @param sideSizeImage The size of image side
	 * @param colorStroke The stroke color
	 * @param sizeStartingPoint The diameter of the stroke's starting point
	 * @param colorStartingPoint The color of the stroke's starting point
	 */
	public void getPngImage(File file, String command, int sideSizeImage, Color colorStroke, int sizeStartingPoint, Color colorStartingPoint) {
		Vector<Point2D> stroke = getTemplate(command);
		Canvas canvas = new Canvas(sideSizeImage, sideSizeImage);
		CPolyLine polyline = GestureUtils.asPolyLine(stroke);
		int maxSide = Math.max((int)(polyline.getMaxX() - polyline.getMinX()), (int)(polyline.getMaxY() - polyline.getMinY()));
		canvas.addShape(polyline);
		BufferedImage imageGesture = new BufferedImage(sideSizeImage, sideSizeImage, BufferedImage.TYPE_INT_ARGB);
		double ds = (sideSizeImage - 10)/(double)maxSide;
		polyline.setAntialiased(true).setFilled(false).setOutlinePaint(colorStroke);
		Graphics g = imageGesture.getGraphics();
		CRectangle bg = new CRectangle(0, 0, maxSide+9, maxSide+9);
		canvas.addShape(bg);
		bg.setFillPaint(Color.WHITE).setOutlined(false);
		bg.paint(g);
		polyline.setReferencePoint(0.5, 0.5).translateTo(sideSizeImage/2, sideSizeImage/2).scaleBy(ds);
		polyline.fixReferenceShapeToCurrent();
		polyline.paint(g);
		CEllipse startPoint = new CEllipse(polyline.getStartX() - (sizeStartingPoint/2), 
				polyline.getStartY() - (sizeStartingPoint/2), 
				sizeStartingPoint, sizeStartingPoint);
		canvas.addShape(startPoint);
		startPoint.setFillPaint(colorStartingPoint).setOutlinePaint(colorStartingPoint).setPickable(false).setAntialiased(true);
		startPoint.paint(g);
		try {
			ImageIO.write(imageGesture, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract double distance(String gesture1, String gesture2);
	
	public int getMinimumStrokeLength() {
		return minimumStrokeLength;
	}

	public void setMinimumStrokeLength(int minimumStrokeLength) {
		this.minimumStrokeLength = minimumStrokeLength;
	}
}
