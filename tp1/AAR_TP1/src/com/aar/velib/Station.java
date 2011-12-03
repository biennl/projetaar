package com.aar.velib;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aar.util.HibernateUtil;

public class Station implements Serializable {
	private int velibId;
	private String nickname;
	private String address;
	private String fullAddress;
	private double latitude;
	private double longitude;
	private int isOpen;
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

	public int isOpen() {
		return isOpen;
	}

	public void setOpen(int isOpen) {
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

	public long nombreVersions() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		long n = 0;
		try {
			transaction = session.beginTransaction();
			String strQuery = "select count(version) from Station where velibId ="
					+ getVelibId();
			Query query = session.createQuery(strQuery);
			n = (Long) query.uniqueResult();
			System.out.println(n);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}
}
