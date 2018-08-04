package org.com.as.utility;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.com.as.Log4JInitServlet;


@Provider
@PreMatching

public class CorsFilter  implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String CORS_REQUEST_PROP = "CorsFilter.isPreflight";

	private static final Logger log = Logger
			.getLogger(CorsFilter.class);

    
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
    	log.info( "Is Preflight Request--" + isPreflightRequest(request));
    	if (isPreflightRequest(request)) {
            request.abortWith(Response.ok().build());            
            return;
        }
    }

    private static boolean isPreflightRequest(ContainerRequestContext request) {
    	log.info("Is Preflight Method --" + request.getMethod());
    	log.info("Origin--" + request.getHeaderString("Origin"));
    	return request.getHeaderString("Origin") != null
                && request.getMethod().equalsIgnoreCase("OPTIONS");
    }

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response)
            throws IOException {
    	log.info(" Set Response Header");
    	log.info("CORS_REQUEST_PROP--" +request.getProperty(CORS_REQUEST_PROP));
            response.getHeaders().add("Access-Control-Allow-Origin", "http://localhost:8081");
            response.getHeaders().add("Access-Control-Allow-Credentials", "true");
            response.getHeaders().add("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            response.getHeaders().add("Access-Control-Allow-Headers",
                    "Origin, X-Requested-With, Content-Type, Accept, Authorization, X-CSRF-Token, " +
                    "Accept-Version, Content-Length, Content-MD5,  Date, X-Api-Version, X-File-Name");
            log.info("Access-Control-Origin--" + response.getHeaderString("Access-Control-Allow-Origin"));
        
    }
}