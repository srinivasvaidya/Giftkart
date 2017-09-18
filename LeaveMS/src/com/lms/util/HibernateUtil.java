package com.lms.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory=buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		 
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
	public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
