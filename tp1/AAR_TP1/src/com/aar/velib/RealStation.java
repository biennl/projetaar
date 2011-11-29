package com.aar.velib;

import java.sql.Timestamp;

public class RealStation {

	private int velibID;
	private String fullAddress;
	private double latitude;
	private double longitude;
	private Timestamp start;

	public int getVelibID() {
		return velibID;
	}

	public void setVelibID(int velibID) {
		this.velibID = velibID;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAdress) {
		this.fullAddress = fullAdress;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

}
