package br.com.hibernate.demo.factory;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

	public static Session getSessionByTheHibernateFactory() {
		return new Configuration().configure().buildSessionFactory().getCurrentSession();
	}

}
