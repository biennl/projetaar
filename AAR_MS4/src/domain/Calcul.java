package domain;

import java.util.ArrayList;

public class Calcul {

	private int id;
	private int num1;
	private int num2;
	private int result;
	private String idSession;

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
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
