package com.spring.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//note not needed since by default its singleton
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class SingletonBean {

    public SingletonBean(){
        System.out.println("creating singleton bean!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public String getMyScope(){
        return "I am Singleton!!";
    }
}
