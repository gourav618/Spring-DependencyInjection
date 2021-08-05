package com.spring.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("### In the LifeCycle Bean Constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("### Bean Factory has been Set");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("### Bean Name is : "+s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("### LifeCycleBean has been terminated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("### LifeCycleBean has its properties set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("### Application Context has been Set");
    }


    public void beforeInit() {
        System.out.println("### LifeCycleBean Before Initialization");
    }

    public void afterInit() {
        System.out.println("### LifeCycleBean after Initialization");
    }
}
