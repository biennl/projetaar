package domain;

import java.util.ArrayList;

public class Calcul {

	public static double sommeDeList(ArrayList<Double> list) {
		double result = 0;
		for (double d : list) {
			result += d;
		}
		return result;
	}

	public static double somme(double nb, double sum) {
		return nb + sum;
	}

}
