package com.chidiudo.userservice.web_scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RandomNumberService {

    private final int value;

    public RandomNumberService() {
        this.value = new Random().nextInt(1000);
    }

    public int getValue() {
        return value;
    }
}
