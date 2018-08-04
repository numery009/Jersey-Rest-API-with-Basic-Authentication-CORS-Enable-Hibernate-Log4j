package org.com.as;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("deprecation")
public class HibernateConnector {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		Configuration configuration = new Configuration();

		configuration.configure();

		@SuppressWarnings("deprecation")
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();	
		
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		return sessionFactory;

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

}