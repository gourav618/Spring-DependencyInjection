package com.spring.sfgdi.controllers;


import com.spring.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

    // private property declared for manual DI
    private GreetingService greetingService;

    @Qualifier("setterInjectedGreetingService")
    //setter for above service Object
    //need to tell spring explicitly that we need to Inject this using autowired annotation
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }


}
