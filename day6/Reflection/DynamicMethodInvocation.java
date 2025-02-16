package com.week4.day6.reflection;
import java.lang.reflect.Method;
import java.util.Scanner;

//class math operation
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {

        //create a scanner object
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        // load the class
        Class<?> mathClass = MathOperations.class;

        // Create an instance dynamically using constructor
        MathOperations mathInstance = (MathOperations) mathClass.getDeclaredConstructor().newInstance();

        // Get the method dynamically
        Method method = mathClass.getMethod(methodName, int.class, int.class);

        // Invoke the method
        int result = (int) method.invoke(mathInstance, num1, num2);

        // Print the result
        System.out.println("Result: " + result);
    }
}
