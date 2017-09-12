package com.ila.framework;
import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class AuthHeadersRequestFilter implements ClientRequestFilter {

    private final String authToken;

    public AuthHeadersRequestFilter(String authtoken) {
        authToken = authtoken;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("Authorization", authToken);
    }
}