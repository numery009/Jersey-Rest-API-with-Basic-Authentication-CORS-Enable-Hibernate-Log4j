package org.com.as.user.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.com.as.user.dao.UserLoginHistoryDAO;
import org.com.as.user.vo.UserLogInHistory;

public class UserLoginHistoryService  {
	private static final Logger log = Logger
			.getLogger(UserLoginHistoryService.class);	

	/*
	 * This is the service level Code of the All UserLogInHistory
	 */
	public List<UserLogInHistory> getAllUserlogInHisotry() {
		log.info("Start Service layer for get all UserLogInHistory");
		UserLoginHistoryDAO userLogInHisotryDAO = new UserLoginHistoryDAO();
		log.info("Start Service layer for get all UserLogInHistory");
		return userLogInHisotryDAO.getAllUserLoginHistoryList();
	}
}
