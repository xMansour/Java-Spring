package com.mansour;

public class Deer extends Animal implements Vegetarian{
    @Override
    public void move() {
        System.out.println("Walking");
    }
}
