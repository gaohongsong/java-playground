package com.onyx.springbootdemo;

import com.onyx.springbootdemo.resource.UserResource;
import io.swagger.annotations.Api;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
@Api
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserResource.class);
    }
}
