package com.aar.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory session;
	static {
		try {
			session = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {

			System.out
					.println("probleme lors de l'initialisation de la session: "
							+ e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return session;
	}
}
