package com.mansour;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfiguration.class);
        context.refresh();
        Employee employee = context.getBean(Employee.class);
        System.out.println("employee = " + employee);

        context.close();
    }
}
