package com.aar.velib;

import java.sql.Timestamp;

public class Station {
	private int velibId;
	private String nickname;
	private String address;
	private String fullAddress;
	private double latitude;
	private double longitude;
	private boolean isOpen;
	private boolean valid;
	private int version;
	private Timestamp start;
	private Timestamp stop;

	public int getVelibId() {
		return velibId;
	}

	public void setVelibId(int velibId) {
		this.velibId = velibId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
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

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getStop() {
		return stop;
	}

	public void setStop(Timestamp stop) {
		this.stop = stop;
	}

	public int nombreVersions() {

		return 0;
	}

}
