package org.com.as.user.controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.com.as.user.service.UserLoginHistoryService;
import org.com.as.user.vo.UserLogInHistory;

@Path("/secured/userloginhistory")
public class UserLogInHistoryController {
	private static final Logger log = Logger
			.getLogger(UserLogInHistoryController.class);

	public UserLogInHistoryController() {
		// TODO Auto-generated constructor stub
		super();
	}

	/*
	 * This is the controller level Code to get all UserlogInHistoryAngular
	 * information
	 */

	@GET
	@Path("/getall")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getAllUserLogInHistoryAngular() {
		log.info("Start Controller layer for Get All UserlogInHistory");
		UserLoginHistoryService userLogInHistoryService = new UserLoginHistoryService();

		GenericEntity<List<UserLogInHistory>> userLoginHistory = new GenericEntity<List<UserLogInHistory>>(
				userLogInHistoryService.getAllUserlogInHisotry()) {
		};
		log.info("End Controller layer for Get All UserlogInHistory");
		return Response.status(200).entity(userLoginHistory).build();
	}
}
