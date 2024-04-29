package com.mansour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import java.util.List;

public class Employee {
    private String name;
    private int age;
    private Department department;

    private List<Address> addressList;

    public Employee() {
    }

    public Employee(List<Address> addressList) {
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    @Autowired
    @Qualifier("dept2")
    public void setDepartment(Department department) {
        this.department = department;
    }


    public void init(){
        System.out.println("Bean init method...");
    }

    public void destroy(){
        System.out.println("Bean destroy method...");
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", addressList=" + addressList +
                '}';
    }
}
