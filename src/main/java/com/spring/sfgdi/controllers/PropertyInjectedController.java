package com.spring.sfgdi.controllers;

import com.spring.sfgdi.services.GreetingService;
/*
Property and setter injected way is not preferred
the most preferred way is using Constructor
 */
public class PropertyInjectedController {

    // public property declared for manual DI
    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
