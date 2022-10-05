package com.chidiudo.userservice.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

// This endpoint will be part of actuator's endpoints

@Component
@Endpoint(id = "myendpoint")
public class MyCustomEndpoint {

    @ReadOperation
    public String test() {
        return "This is my custom Endpoint";
    }


}
