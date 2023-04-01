package com.onyx.springbootdemo.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@Path("/users")
// @EnableSwagger2
// @Api(value = "User Service", tags = {"endpoints for user service"})
public class UserResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "hello cc, i miss you";
    }
}
