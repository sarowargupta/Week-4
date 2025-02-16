package com.week4.day6.reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

// Student class
class Student {
    private int rollNumber;
    public String name;

    // Constructors
    public Student() {
        System.out.println("Student Details");
    }
    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    // Methods
    public void display() {
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name);
    }

    //private method
    private void secretMethod() {
        System.out.println("This is a private method.");
    }
}

public class GetClassInformation {
    public static void main(String[] args) throws ClassNotFoundException {

        //create a scanner object
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();

        // Specify the package where the class is located
        String packageName = "com.week4.day6.reflection.";
        String fullClassName = packageName + className;

        // Load the class
        Class<?> cls = Class.forName(fullClassName);

        // Display class name
        System.out.println("Class: " + cls.getName());

        // Display fields
        System.out.println("\nFields:");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // Display methods
        System.out.println("\nMethods:");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // Display constructors
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}

