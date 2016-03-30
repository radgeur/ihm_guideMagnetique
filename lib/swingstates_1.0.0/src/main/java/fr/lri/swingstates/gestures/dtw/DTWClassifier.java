package fr.lri.swingstates.gestures.dtw;

/*  
 *   Authors: Caroline Appert (caroline.appert@lri.fr)
 *   Copyright (c) Universite Paris-Sud XI, 2007. All Rights Reserved
 *   Licensed under the GNU LGPL. For full terms see the file COPYING.
 */

import java.awt.geom.Point2D;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import fr.lri.swingstates.gestures.AbstractClassifier;
import fr.lri.swingstates.gestures.Gesture;
import fr.lri.swingstates.gestures.GestureClass;
import fr.lri.swingstates.gestures.GestureUtils;
import fr.lri.swingstates.gestures.Score;
import fr.lri.swingstates.gestures.shapeMatching.NamedGesture;
import fr.lri.swingstates.gestures.shapeMatching.ShapeMatchingClassifier;

/**
 * A very simple recognizer that performs simple shape matching based on a single example per class (one template):
 * <ol>
 * <li> Resample the gesture to classify so it contains the number of uniformly spaced points as the gesture templates contained in this classifier. </li>
 * <li> For each template, scale the input gesture so its bounding box matches the bounding box of the template
 * and compute the sum of distances point to point between the template points and the input gesture points. </li>
 * <li> Returns the name of the class for the template that minimizes this sum of distances. </li>
 * </ol>
 * 
 * @author Caroline Appert
 *
 */
public class DTWClassifier extends AbstractClassifier {

	protected ArrayList<GestureClass>    classes = new ArrayList<GestureClass>();

	public DTWClassifier() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public double distance(String gesture1, String gesture2) {
		int index1 = classesNames.indexOf(gesture1);
		int index2 = classesNames.indexOf(gesture2);
		
		if(!Double.isNaN(distances[index1][index2])) {
			return distances[index1][index2];
		}
		
		Vector<Point2D> template1 = getTemplate(gesture1);
		Vector<Point2D> template2 = getTemplate(gesture2);
		
		double minDis = distance(template1, template2);
		GestureClass gc1 = classes.get(index1);
		Vector<Gesture> examples1 = gc1.getGestures();
		for (Iterator<Gesture> iterator = examples1.iterator(); iterator.hasNext();) {
			Vector<Point2D> ex1  = iterator.next().getPoints();
			double dis = distance(ex1, template2);
			if(dis < minDis) {
				minDis = dis;
			}
		}
		distances[index1][index2] = minDis;
		
		minDis = distance(template2, template1);
		GestureClass gc2 = classes.get(index2);
		Vector<Gesture> examples2 = gc2.getGestures();
		for (Iterator<Gesture> iterator = examples2.iterator(); iterator.hasNext();) {
			Vector<Point2D> ex2  = iterator.next().getPoints();
			double dis = distance(template1, ex2);
			if(dis < minDis) {
				minDis = dis;
			}
		}

		distances[index2][index1] = minDis;
		
		return distances[index1][index2];
	}

	/**
	 * {@inheritDoc}
	 */
	public double distance(Gesture gesture, String gesture2) {
		return distance(gesture.getPoints(), gesture2);
	}

	public double distance(Vector<Point2D> inputPoints, String gesture2) {
		return distance(inputPoints, getTemplate(gesture2));
	}

	public double distance(Vector<Point2D> inputPoints1, Vector<Point2D> inputPoints2) {
		// TODO
		return -1;
	}

	/**
	 * {@inheritDoc}
	 */
	public String classify(Gesture g) {
		if(GestureUtils.pathLength(g.getPoints()) < minimumStrokeLength) return null;

		double minScore = Double.MAX_VALUE;
		double currentScore = -1;
		GestureClass recognized = null;


		for (Iterator<GestureClass> classesIterator = classes.iterator(); classesIterator.hasNext();) {
			GestureClass nextClass = classesIterator.next();
			if(nextClass.getGestures().size() > 0) {
				for (Iterator<Gesture> gesturesIterator = nextClass.getGestures().iterator(); gesturesIterator.hasNext();) {
					Vector<Point2D> gesturePoints = gesturesIterator.next().getPoints();
					currentScore = distance(g.getPoints(), gesturePoints);
					if (currentScore < minScore) {
						minScore = currentScore;
						recognized = nextClass;
					}
				}
			} 
			Vector<Point2D> gesturePoints = getTemplates().get(getClassesNames().indexOf(nextClass.getName()));
			if(gesturePoints != null) {
				currentScore = distance(g.getPoints(), gesturePoints);
				if (currentScore < minScore) {
					minScore = currentScore;
					recognized = nextClass;
				}
			}
		}
		return recognized.getName();
	}

	/**
	 * Builds a new classifier by loading its definition in a file.
	 * 
	 * @param file
	 *            The name of the file containing the definition of the
	 *            classifier.
	 * @return The newly created classifier.
	 */
	public static DTWClassifier newClassifier(String file) {
		return newClassifier(new File(file));
	}

	/**
	 * Builds a new classifier by loading its definition in a file.
	 * 
	 * @param filename
	 *            The name of the file containing the definition of the
	 *            classifier.
	 * @return The newly created classifier.
	 */
	public static DTWClassifier newClassifier(File filename) {
		DTWClassifier c = new DTWClassifier();
		try {
			c.read(new DataInputStream(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * Builds a new classifier by loading its definition in a url.
	 * 
	 * @param url
	 *            The url containing the definition of the classifier.
	 * @return The newly created classifier.
	 */
	public static DTWClassifier newClassifier(URL url) {
		DTWClassifier c = new DTWClassifier();
		try {
			URLConnection urlc = null;
			urlc = url.openConnection();
			c.read(new DataInputStream(urlc.getInputStream()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * {@inheritDoc}
	 */
	public int addClass(String className) {
		int index = super.addClass(className);
		if(index == -1) return -1;
		GestureClass gcr = new GestureClass(className);
		classes.add(gcr);
		fireClassAdded(className);
		return index;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void renameClass(String previousClassName, String newClassName) {
		int index = classesNames.indexOf(previousClassName);
		if(index == -1) return;
		GestureClass gc = classes.get(index);
		gc.setName(newClassName);
		super.renameClass(previousClassName, newClassName);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void removeClass(String className) {
		int index = classesNames.indexOf(className);
		if(index == -1) return;
		super.removeClass(className);
		classes.remove(index);
		fireClassRemoved(className);
	}
	
	/**
	 * Adds a class and set the template for this class.
	 * @param className The name of the class to add
	 * @param template The template for the class <code>className</code>
	 */
	public void addClass(String className, Vector<Point2D> template) {
		int index = addClass(className);
		templates.set(index, template);
	}

	protected Object read(DataInputStream in) throws IOException {
		int nClasses = in.readInt();
		for (int i = 0; i < nClasses; i++) {
			classesNames.add(in.readUTF());
			int nbPoints = in.readInt();
			if(nbPoints == -1) {
				templates.add(null);
			} else {
				Vector<Point2D> points = new Vector<Point2D>();
				for (int j = 0; j < nbPoints; j++) {
					points.add(new Point2D.Double(in.readDouble(), in.readDouble()));
				}
				templates.add(points);
			}
			GestureClass gestureClass = new GestureClass(classesNames.get(i));
			classes.add(gestureClass);
			gestureClass.read(in);

		}
		try {
			String s = in.readUTF();
			if(s.compareTo("minimumStrokeLength") == 0) minimumStrokeLength = in.readInt();
		} catch(IOException ioe) {
			minimumStrokeLength = 20;
		}
		return this;
	}

	protected void write(DataOutputStream out) throws IOException {
		out.writeInt(classesNames.size());
		for (int i = 0; i < classesNames.size(); i++) {
			out.writeUTF(classesNames.get(i));
			if(templates.get(i) != null) {
				out.writeInt(templates.get(i).size());
				for (Iterator<Point2D> iterator = templates.get(i).iterator(); iterator.hasNext();) {
					Point2D next = iterator.next();
					out.writeDouble(next.getX());
					out.writeDouble(next.getY());
				}
			} else {
				out.writeInt(-1);
			}
			classes.get(i).write(out);
		}
		out.writeUTF("minimumStrokeLength");
		out.writeInt(minimumStrokeLength);
	}

	/**
	 * {@inheritDoc}
	 */
	public Vector<Score> sortedClasses(Gesture g) {
		Vector<Score> sortedScores = new Vector<Score>();

		double score;
		double minClassScore = 0;
		for (int nc = 0; nc < classes.size(); nc++) {
			minClassScore = Integer.MAX_VALUE;
			if(classes.get(nc).getGestures().size() > 0) {
				for (Iterator<Gesture> gesturesIterator = classes.get(nc).getGestures().iterator(); gesturesIterator.hasNext();) {
					Vector<Point2D> gesturePoints = gesturesIterator.next().getPoints();
					score = distance(g.getPoints(), gesturePoints);
					if (score < minClassScore)
						minClassScore = score;
				}
			} else {
				Vector<Point2D> gesturePoints = getTemplates().get(nc);
				score = distance(g.getPoints(), gesturePoints);
				if (score < minClassScore)
					minClassScore = score;
			}
			if (nc == 0) {
				sortedScores.add(new Score(classes.get(nc).getName(), minClassScore));
			} else {
				int i = 0;
				while (i < sortedScores.size() && sortedScores.get(i).getScore() < minClassScore)
					i++;
				sortedScores.add(i, new Score(classes.get(nc).getName(), minClassScore));
			}
		}

		return sortedScores;
	}

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
	 * {@inheritDoc}
	 */
	public void removeExample(Gesture example) {
		for (Iterator<GestureClass> iterator = classes.iterator(); iterator.hasNext();) {
			GestureClass next = iterator.next();
			if(next != null) {
				invalidateDistance(next.getName());
				next.removeExample(example);
				fireExampleRemoved(next.getName(), example);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addExample(String className, Gesture example) {
		invalidateDistance(className);
		int index = classesNames.indexOf(className);
		if(index == -1) return;
		GestureClass gestureClass = classes.get(index);
		if(gestureClass != null) {
			gestureClass.addExample(example);
			fireExampleAdded(className, example);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Vector<Gesture> getExamples(String className)
			throws UnsupportedOperationException {
		int index = classesNames.indexOf(className);
		if(index == -1) return null;
		GestureClass gc = classes.get(index);
		return gc.getGestures();
	}

	/**
	 * {@inheritDoc}
	 */
	public void reset() {
		super.reset();
		classes.clear();
	}

}

