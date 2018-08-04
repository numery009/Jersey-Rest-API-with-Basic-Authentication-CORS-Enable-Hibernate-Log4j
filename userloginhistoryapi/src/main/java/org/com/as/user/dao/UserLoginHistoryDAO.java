package org.com.as.user.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.com.as.HibernateConnector;
import org.com.as.user.vo.UserLogInHistory;

public class UserLoginHistoryDAO {

	private static final Logger log = Logger
			.getLogger(UserLoginHistoryDAO.class);

	private static SessionFactory sessionFactory;

	static {

		sessionFactory = HibernateConnector.getSessionFactory();
	}

	/*
	 * This code fetch all the UserLoginDate information from the database
	 */
	@SuppressWarnings("unchecked")
	public List<UserLogInHistory> getAllUserLoginHistoryList() {
		List<UserLogInHistory> userLogInHistoryN = null;
		log.info("Start DAO layer for get all UserLoginDate ");
		try {
			Session session = HibernateConnector.getSessionFactory()
					.openSession();
			userLogInHistoryN = session.createCriteria(UserLogInHistory.class)
					.list();
			session.close();
		} catch (HibernateException ex) {
			log.error(ex.toString());
		}
		log.info(userLogInHistoryN.toString());
		log.info("End DAO layer for get all UserLoginDate ");
		return userLogInHistoryN;
	}
}
