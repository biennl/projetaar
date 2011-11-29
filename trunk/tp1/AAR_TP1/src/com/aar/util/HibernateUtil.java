package com.aar.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// private static final SessionFactory session;
	// static {
	// try {
	// session = new Configuration().configure().buildSessionFactory();
	// } catch (Throwable e) {
	//
	// System.out
	// .println("probleme lors de l'initialisation de la session: "
	// + e.getMessage());
	// throw new ExceptionInInitializerError(e);
	// }
	// }
	//
	// public static SessionFactory getSessionFactory() {
	// return session;
	// }
}
