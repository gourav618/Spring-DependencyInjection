package com.spring.sfgdi.services;

//Note: Set using java config and since we had service name we will name our method as same not callName with lowerCase
//@Profile("EN")
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World -- Eng Greeting";
    }
}
