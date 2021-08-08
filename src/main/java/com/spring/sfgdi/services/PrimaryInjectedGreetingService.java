package com.spring.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//setting the bean as primary , when no qualifier is given to choose which bean to select
//@Primary
//@Service
//since using java based config
public class PrimaryInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hi Folks -- from primary Bean";
    }
}
