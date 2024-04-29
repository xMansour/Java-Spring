package com.mansour;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanLifeCycle implements InitializingBean, DisposableBean, BeanPostProcessor {


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After beans were initialized");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Before beans were destroyed");

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("In postProcessBeforeInitialization with bean: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("In postProcessAfterInitialization with bean: " + beanName);
        return bean;
    }
}
