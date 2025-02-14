package com.week4.day4;

public class ExceptionPropagation {


    // method1() throws an ArithmeticException (10 / 0)
    public static void method1() {
        int result = 10 / 0;
    }

    // Method 2: Calls method1()
    public static void method2() {

        method1();
    }

    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {

            // Handles exception from method1()
            System.out.println("Handled exception in main");
        }
    }
}

