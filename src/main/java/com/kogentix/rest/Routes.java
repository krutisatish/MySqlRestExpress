package com.kogentix.rest;

import com.kogentix.rest.config.Configuration;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;

public abstract class Routes {

    public static void define(Configuration config, RestExpress server) {
        server.uri("/{tableName}", config.getController())
                .method(HttpMethod.GET)
                .name(Constants.Routes.SINGLE_SAMPLE);
        server.uri("/{tableName}/{values}", config.getController())
                .method(HttpMethod.PUT)
                .name(Constants.Routes.SINGLE_SAMPLE);


    }
}
