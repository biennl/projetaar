package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aar.util.HibernateUtil;
import com.aar.velib.Station;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Station station = new Station();
		station.setVelibId(8014);
		long n = station.nombreVersions();

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session
					.createSQLQuery("SELECT DISTINCT(nickname) FROM station WHERE GetNumberVersion(velibid) = (SELECT Max(GetNumberVersion(velibid)) FROM station)");
			List result = query.list();
			for (int i = 0; i < result.size(); i++) {
				String s = (String) result.get(i);
				System.out.println(s);
			}

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
