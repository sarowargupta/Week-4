package com.week4.day6.reflection;
import java.lang.reflect.Method;

class Student1{
    private String name;

    public Student1() {
        this.name = "Alice";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicallyCreateObject {
    public static void main(String[] args) throws Exception {

        // Get the Student class object
        Class<?> studentClass = Class.forName("com.week4.day6.reflection.Student1");

        // Create an instance dynamically without using new keyword
        Student1 studentInstance = (Student1) studentClass.getDeclaredConstructor().newInstance();

        // Invoke the display method
        Method displayMethod = studentClass.getMethod("display");
        displayMethod.invoke(studentInstance);
    }
}



