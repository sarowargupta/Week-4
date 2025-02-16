package com.week4.day6.reflection;
import java.lang.reflect.Method;

//calculator class
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Load the class
        Class<?> cls = calculator.getClass();

        // Access private method 'multiply' using reflection
        Method multiplyMethod = cls.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);

        // Invoke the method  and get the result
        int result = (int) multiplyMethod.invoke(calculator, 9, 10);

        // Print the result
        System.out.println("Multiplication Result: " + result);
    }
}
