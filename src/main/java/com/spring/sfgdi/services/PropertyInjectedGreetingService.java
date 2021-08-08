package com.spring.sfgdi.services;

import org.springframework.stereotype.Service;


public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hi Folks!! --Property";
    }
}
