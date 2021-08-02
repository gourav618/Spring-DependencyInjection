package com.spring.sfgdi.controllers;

import com.spring.sfgdi.services.GreetingService;
import com.spring.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//least preferred method
class PropertyInjectedControllerTest {
    //manual way of property/dependency injection in setup method where we create Object
    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        //setting the controller Object by directly accessing  GreetingServiceImpl
        controller = new PropertyInjectedController();

        controller.greetingService = new GreetingServiceImpl() ;
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}