package com.spring.sfgdi.controllers;

import com.spring.sfgdi.services.GreetingService;

public class ConstructorInjectedController {

    private final GreetingService greetingService;

    //constructor for final variable
    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
