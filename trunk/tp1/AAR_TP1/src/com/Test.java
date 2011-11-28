package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aar.util.HibernateUtil;
import com.aar.velib.RealStation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from realstation");
			query.setMaxResults(10);
			List Stations = query.list();

			for (Iterator iter = Stations.iterator(); iter.hasNext();) {
				RealStation s = (RealStation) iter.next();
				System.out.println(s.getVelibID());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		// int param = 901;
		// Query query = session.getNamedQuery("getnumberversion").setParameter(
		// param, 901);
		// List res = query.list();
		// for (int i = 0; i < res.size(); i++) {
		// Station station = (Station) res.get(i);
		// System.out.println(station.getNickname());
		// }

	}
}
