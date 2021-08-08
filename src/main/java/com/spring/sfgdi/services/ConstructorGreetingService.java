package com.spring.sfgdi.services;


public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hi Folks!! --constructor";
    }
}
