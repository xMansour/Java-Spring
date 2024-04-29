package com.mansour;

public interface Vegetarian {

     default void eat() {
         System.out.println("Only eats vegetables");
    }
}
