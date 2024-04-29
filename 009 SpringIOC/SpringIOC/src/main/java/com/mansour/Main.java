package com.mansour;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //AbstractApplicationContext should be used instead of the regular ApplicationContext when implementing DisposableBean
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        applicationContext.registerShutdownHook();
        Employee employee = applicationContext.getBean(Employee.class, "emp");
        System.out.println("employee = " + employee);
    }
}
