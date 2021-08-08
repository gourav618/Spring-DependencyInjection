package com.spring.sfgdi.config;

//java based config example

import com.spring.sfgdi.repositories.EnglishGreetingRepository;
import com.spring.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.spring.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Configuration
public class GreetingServiceConfig {

    //beans are created here for the greeting services and bean name by default is method name
    //Note: @Service anotation removed from these classes and bean are init here
    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    //setting bean as primary
    @Primary
    @Bean
    PrimaryInjectedGreetingService primaryInjectedGreetingService(){
        return new PrimaryInjectedGreetingService();
    }

    //java config has use DI to use this in eng greeting service
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }
}
