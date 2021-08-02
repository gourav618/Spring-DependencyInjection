package com.spring.sfgdi.controllers;


import com.spring.sfgdi.services.GreetingService;

public class SetterInjectedController {

    // private property declared for manual DI
    private GreetingService greetingService;

    //setter for above service Object
    public String getGreeting(){
        return greetingService.sayGreeting();
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
