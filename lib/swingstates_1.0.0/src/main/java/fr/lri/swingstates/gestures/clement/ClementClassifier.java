/*
 * Authors: Clement Pillias, Olivier Bau and Caroline Appert (caroline.appert@lri.fr) Copyright (c) Universite
 * Paris-Sud XI, 2007. All Rights Reserved Licensed under the GNU LGPL. For full
 * terms see the file COPYING.
 */
package fr.lri.swingstates.gestures.clement;

import java.awt.geom.Point2D;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Vector;

import fr.lri.swingstates.gestures.GestureUtils;
import fr.lri.swingstates.gestures.clement.optimizers.TwoDimensions.OptimizationParameters;
import fr.lri.swingstates.gestures.clement.optimizers.TwoDimensions.UniformScaleAndRotation;
import fr.lri.swingstates.gestures.clement.optimizers.TwoDimensions.NonUniformScalingBeforeRotation;
import fr.lri.swingstates.gestures.shapeMatching.ShapeMatchingClassifier;

public class ClementClassifier extends ShapeMatchingClassifier {

	
	public ClementClassifier() {
		super();
		maximumDistance = Double.MAX_VALUE;
	}

	@Override
	public double distance(String gesture1, String gesture2) {
		int index1 = classesNames.indexOf(gesture1);
		int index2 = classesNames.indexOf(gesture2);

		if(!Double.isNaN(distances[index1][index2])) {
			return distances[index1][index2];
		}

		Vector<Point2D> template1 = getTemplate(gesture1);
		Vector<Point2D> template2 = getTemplate(gesture2);

		double minDis = distance(template1, template2);
		ResampledGestureClass gc1 = classes.get(index1);
		Vector<Vector<Point2D>> examples1 = gc1.getResampledGestures();
		for (Iterator<Vector<Point2D>> iterator1 = examples1.iterator(); iterator1.hasNext();) {
			Vector<Point2D> ex1  = iterator1.next();
			double dis = distance(ex1, template2);
			if(dis < minDis) {
				minDis = dis;
			}
		}
		distances[index1][index2] = minDis;

		minDis = distance(template2, template1);
		ResampledGestureClass gc2 = classes.get(index2);
		Vector<Vector<Point2D>> examples2 = gc2.getResampledGestures();
		for (Iterator<Vector<Point2D>> iterator = examples2.iterator(); iterator.hasNext();) {
			Vector<Point2D> ex2  = iterator.next();
			double dis = distance(template1, ex2);
			if(dis < minDis) {
				minDis = dis;
			}
		}
		distances[index2][index1] = minDis;

		return distances[index1][index2];
	}

	@Override
	public double distance(Vector<Point2D> inputPointsResampled1, Vector<Point2D> inputPointsResampled2) {
		OptimizationParameters params = new OptimizationParameters(inputPointsResampled1, inputPointsResampled2);
		UniformScaleAndRotation optimizer = new UniformScaleAndRotation();
		//OptimizationParameters params = new OptimizationParameters(inputPointsResampled2, inputPointsResampled1);
		//NonUniformScalingBeforeRotation optimizer = new NonUniformScalingBeforeRotation();
		return optimizer.optimize(params);
	}
	
	// To define the gesture storage
	public Vector<Point2D> normalize(Vector<Point2D> gesturePoints)
    {
        Vector<Point2D> inputPointsResampled = new Vector<Point2D>();
		GestureUtils.resample(gesturePoints, nbPoints, inputPointsResampled);
		GestureUtils.scaleToSquare(inputPointsResampled, sizeScaleToSquare, inputPointsResampled);
		GestureUtils.translateToOrigin(inputPointsResampled, inputPointsResampled);
		return inputPointsResampled;
    }

	/**
	 * Builds a new classifier by loading its definition in a file.
	 * 
	 * @param file
	 *            The name of the file containing the definition of the
	 *            classifier.
	 * @return The newly created classifier.
	 */
	public static ClementClassifier newClassifier(String file) {
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
	public static ClementClassifier newClassifier(File filename) {
		ClementClassifier c = new ClementClassifier();
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
	public static ClementClassifier newClassifier(URL url) {
		ClementClassifier c = new ClementClassifier();
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

}
