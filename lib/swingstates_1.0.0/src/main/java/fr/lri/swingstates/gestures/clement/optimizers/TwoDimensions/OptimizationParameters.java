/*
 * Authors: Clement Pillias, Olivier Bau and Caroline Appert (caroline.appert@lri.fr) Copyright (c) Universite
 * Paris-Sud XI, 2007. All Rights Reserved Licensed under the GNU LGPL. For full
 * terms see the file COPYING.
 */
package fr.lri.swingstates.gestures.clement.optimizers.TwoDimensions;

import java.awt.geom.Point2D;
import java.util.Vector;

public class OptimizationParameters {

	// Variables used by all 2D Distance Optimizers variants.
	public double A = 0;
	public double B = 0;
	public double C = 0;
	public double D = 0;
	public double squared_x1 = 0;
	public double squared_y1 = 0;
	public double x1_y1 = 0;
	public double squared_distances_sum2 = 0;

	public OptimizationParameters(Vector<Point2D> inputPointsResampled1, Vector<Point2D> inputPointsResampled2) {

		for (int index = 0; index<inputPointsResampled1.size(); ++index) {

			Point2D point1 = inputPointsResampled1.elementAt(index);
			Point2D point2 = inputPointsResampled2.elementAt(index);

			double x1 = point1.getX();
			double y1 = point1.getY();
			double x2 = point2.getX();
			double y2 = point2.getY();

			A += x1*x2;
			B += y1*x2;
			C += x1*y2;
			D += y1*y2;
			squared_x1 += x1*x1;
			squared_y1 += y1*y1;
			x1_y1 += x1*y1;
			squared_distances_sum2 += x2*x2 + y2*y2;
		}

	}

}
