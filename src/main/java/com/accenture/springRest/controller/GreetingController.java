package com.accenture.springRest.controller;

import com.accenture.springRest.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class GreetingController {
    private final GreetingService greetingServiceImpl;
    @Autowired
    public GreetingController(GreetingService greetingServiceImpl) {
        this.greetingServiceImpl = greetingServiceImpl;
    }

    @GetMapping("/api/message/v1") //request param muss mit ? hinter die url gehängt werden ie ./api/message/v1?name=Susi
    public ResponseEntity<String> getMessage(@RequestParam(name = "test", required = false) String name){ //hier ./api/message/v1?test =Susi
        String message = Objects.nonNull(name) ?
                greetingServiceImpl.message(name) :
                greetingServiceImpl.message();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
