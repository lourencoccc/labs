/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.rs.client;

import java.io.Serializable;

import org.jboss.resteasy.client.ClientRequest;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class F1HttpResourceClient implements Serializable {

    private static final long serialVersionUID = -5539352726311108889L;

    private String baseUrl = "http://localhost:8080/f1-ws/rest";

    public F1HttpResourceClient(String baseUrl) {
        super();
        if (baseUrl != null) {
            this.baseUrl = baseUrl;
        }
    }

    public ClientRequest createRequest(final String url) {
        return new ClientRequest(baseUrl + url);
    }

    public ClientRequest createRequest(final StringBuilder url) {
        return new ClientRequest(baseUrl + url);
    }

}
