package com.mansour;

import java.util.Arrays;

public class Calculator {

    public int addition(int x, int y) {
        return x + y;
    }

    public double addition(double x, double y) {
        return x + y;
    }

    public int addition(int... args) {
        return Arrays.stream(args).sum();
    }

}
