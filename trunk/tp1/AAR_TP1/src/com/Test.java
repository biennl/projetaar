package com;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aar.util.HibernateUtil;
import com.aar.velib.Station;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// Query query = session.createQuery("from realstation");
			// query.setMaxResults(10);
			// List Stations = query.list();
			//
			// for (Iterator iter = Stations.iterator(); iter.hasNext();) {
			// RealStation s = (RealStation) iter.next();
			// System.out.println(s.getVelibID());
			// }

			Station s = new Station();
			s.setVelibId(1234);
			s.setAddress("test adress");
			s.setVersion(10);
			session.save(s);
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
