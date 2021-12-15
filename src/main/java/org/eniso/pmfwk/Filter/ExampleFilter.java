package org.eniso.pmfwk.Filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

public class ExampleFilter implements ContainerRequestFilter {
    // private final JwtUtil jwtUtil = new JwtUtil();


    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        UriInfo s = containerRequestContext.getUriInfo();
        // Message m = jwtUtil.parseToken(authHeader);

        System.out.println(">>>>>> " + s.getAbsolutePath());

        //if (m == null){
        //    Exception cause = new IllegalArgumentException("Auth Header was not specified");
        //    throw new WebApplicationException(cause, Response.Status.UNAUTHORIZED);
        //}
    }
}
