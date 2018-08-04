package org.com.as.utility;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.com.as.Log4JInitServlet;
import org.com.as.user.controller.UserLogInHistoryController;
import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecureAPI  implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_BASIC = "Basic ";
	private static final String SECURED_URL_PREFIX = "secured";

	
	private static final Logger log = Logger
			.getLogger(SecureAPI.class);
		
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(
					AUTHORIZATION_HEADER_KEY);
			if (authHeader != null && authHeader.size() > 0) {
				String autotoken = authHeader.get(0);
				autotoken = autotoken.replaceFirst(AUTHORIZATION_HEADER_BASIC,
						"");
				String decoString = Base64.decodeAsString(autotoken);
				StringTokenizer tokenizer = new StringTokenizer(decoString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				System.out.println( username + " "+ password);
				if ("numery".equals(username) && "password".equals(password)) {
					return;
				}
				
			}

			Response unauthorizedStatus = Response
					.status(Response.Status.FORBIDDEN)
					.entity("User can not access the API.").build();

			requestContext.abortWith(unauthorizedStatus);
		}
	}
}
