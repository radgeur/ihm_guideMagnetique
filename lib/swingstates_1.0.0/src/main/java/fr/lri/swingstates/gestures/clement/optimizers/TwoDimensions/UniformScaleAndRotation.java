package fr.lri.swingstates.gestures.clement.optimizers.TwoDimensions;

public class UniformScaleAndRotation implements TwoDimensionsDistanceOptimizer {

	public double angle;
	public double scale;

	public double optimize(OptimizationParameters params) {
		double X = params.A + params.D;
		double Y = params.B - params.C;
		double squared_distances_sum1 = params.squared_x1 + params.squared_y1;

		double similarity = X*X+Y*Y;
		scale = Math.sqrt(similarity) / squared_distances_sum1;
		angle = Math.atan2(X,Y);
		return params.squared_distances_sum2- similarity /squared_distances_sum1;
	}

}
