package com.spring.sfgdi.config;

//java based config example

import com.spring.sfgdi.services.ConstructorGreetingService;
import com.spring.sfgdi.services.PropertyInjectedGreetingService;
import com.spring.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
