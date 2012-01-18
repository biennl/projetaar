package domain;

import java.util.ArrayList;

public class Calcul {

	private long id;
	private long num1;
	private long num2;
	private long result;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNum1() {
		return num1;
	}

	public void setNum1(long num1) {
		this.num1 = num1;
	}

	public long getNum2() {
		return num2;
	}

	public void setNum2(long num2) {
		this.num2 = num2;
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

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
