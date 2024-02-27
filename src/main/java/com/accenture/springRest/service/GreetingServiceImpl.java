package com.accenture.springRest.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{
    @Override
    public String message() {
        return "Hello World from Service";
    }

    @Override
    public String message(String name) {
        return "Hello World from Service, " + name;
    }
}
