package com.spring.sfgdi.services;

import com.spring.sfgdi.repositories.EnglishGreetingRepository;

//Note: Set using java config and since we had service name we will name our method as same not callName with lowerCase
//@Profile("EN")
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World -- Eng Greeting";
    }
}
