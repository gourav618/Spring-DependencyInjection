package com.spring.sfgdi.controllers;

import com.spring.sfgdi.services.PrimaryInjectedGreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    //no autowired or qualifier needed

    private final PrimaryInjectedGreetingService primaryInjectedGreetingService;

    public MyController(PrimaryInjectedGreetingService primaryInjectedGreetingService) {
        this.primaryInjectedGreetingService = primaryInjectedGreetingService;
    }

    public String sayHello(){

        return primaryInjectedGreetingService.sayGreeting();
    }
}
