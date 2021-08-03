package com.spring.sfgdi.controllers;

import com.spring.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//least preferred method
class PropertyInjectedControllerTest {
    //manual way of property/dependency injection in setup method where we create Object
    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        //setting the controller Object by directly accessing  GreetingServiceImpl
        controller = new PropertyInjectedController();

        controller.greetingService = new ConstructorGreetingService() ;
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}