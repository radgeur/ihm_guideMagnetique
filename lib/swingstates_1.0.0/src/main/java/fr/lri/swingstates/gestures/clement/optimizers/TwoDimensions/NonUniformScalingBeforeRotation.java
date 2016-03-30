package fr.lri.swingstates.gestures.clement.optimizers.TwoDimensions;

public class NonUniformScalingBeforeRotation implements TwoDimensionsDistanceOptimizer {

	public double scale_x;
	public double scale_y;
	public double angle;

	public double optimize(OptimizationParameters params) {
		double L = params.A*params.B + params.C*params.D;
		double P = (params.A*params.A + params.C*params.C)*params.squared_y1 + (params.B*params.B + params.D*params.D)*params.squared_x1;
		double Q = 4*params.squared_x1*params.squared_y1;
		double discriminant = (P*P - L*L*Q);

		double lambda1 = (P - Math.sqrt(discriminant)) / L;
		double diviseur1 = (lambda1*lambda1 - Q);
		double a1 = (4*params.A*params.squared_y1 - 2*params.B*lambda1) / diviseur1;
		double b1 = (4*params.B*params.squared_x1 - 2*params.A*lambda1) / diviseur1;
		double c1 = (4*params.C*params.squared_y1 - 2*params.D*lambda1) / diviseur1;
		double d1 = (4*params.D*params.squared_x1 - 2*params.C*lambda1) / diviseur1;

		double lambda2 = (P + Math.sqrt(discriminant)) / L;
		double diviseur2 = (lambda2*lambda2 - Q);
		double a2 = (4*params.A*params.squared_y1 - 2*params.B*lambda2) / diviseur2;
		double b2 = (4*params.B*params.squared_x1 - 2*params.A*lambda2) / diviseur2;
		double c2 = (4*params.C*params.squared_y1 - 2*params.D*lambda2) / diviseur2;
		double d2 = (4*params.D*params.squared_x1 - 2*params.C*lambda2) / diviseur2;

		double distance1 = 1 + ( (a1*a1+c1*c1)*params.squared_y1 + (b1*b1+d1*d1)*params.squared_x1 + 2*(a1*params.A+b1*params.B+c1*params.C+d1*params.D) ) / params.squared_distances_sum2;
		System.out.println("R^2= " + ((a1*a1+c1*c1)*params.squared_y1 + (b1*b1+d1*d1)*params.squared_x1) + ", R'^2=" + params.squared_distances_sum2 + ", cross=" + (2*(a1*params.A+b1*params.B+c1*params.C+d1*params.D)));
		System.out.println("Distance 1 : " + distance1);
		double scale_x_1 = Math.sqrt(a1*a1 + c1*c1);
		double scale_y_1 = Math.sqrt(b1*b1 + d1*d1);
		System.out.println("Scale 1: Sx=" + scale_x_1 + ", Sy=" + scale_y_1);
		double angle1 = Math.atan2(c1/scale_y_1, -a1/scale_x_1);
		System.out.println("Angle 1: " + angle1);

		double distance2 = 1 + ( (a2*a2+c2*c2)*params.squared_y1 + (b2*b2+d2*d2)*params.squared_x1 + 2*(a2*params.A+b2*params.B+c2*params.C+d2*params.D) ) / params.squared_distances_sum2;
		System.out.println("R^2= " + ((a2*a2+c2*c2)*params.squared_y1 + (b2*b2+d2*d2)*params.squared_x1) + ", R'^2=" + params.squared_distances_sum2 + ", cross=" + (2*(a2*params.A+b2*params.B+c2*params.C+d2*params.D)));
		System.out.println("Distance 2 : " + distance2);
		double scale_x_2 = Math.sqrt(a2*a2 + c2*c2);
		double scale_y_2 = Math.sqrt(b2*b2 + d2*d2);
		System.out.println("Scale 2: Sx=" + scale_x_2 + ", Sy=" + scale_y_2);
		double angle2 = Math.atan2(c2/scale_y_2, -a2/scale_x_2);
		System.out.println("Angle 2: " + angle2);

//		if (Math.abs(Math.log(scale_y_1/scale_x_1)) > 0.3 || scale_x_1<0.2 || scale_y_1<0.2) {
//			if (Math.abs(Math.log(scale_y_2/scale_x_2)) > 0.3 || scale_x_2<0.2 || scale_y_2<0.2)
//				return 2;
//			else return distance2;
//		} else {
//			if (Math.abs(Math.log(scale_y_2/scale_x_2)) > 0.3 || scale_x_2<0.2 || scale_y_2<0.2)
//				return distance1;
//			else return Math.min(distance1, distance2);
//		}
		return Math.min(distance1, distance2);
	}

}
