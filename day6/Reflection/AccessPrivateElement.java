package com.week4.day6.reflection;
import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateElement {
    public static void main(String[] args) throws Exception {
        // Create an instance of Person
        Person person = new Person(25);

        // Load the class
        Class<?> cls = person.getClass();

        // Access private field
        Field ageField = cls.getDeclaredField("age");

        // Allow access to private field
        ageField.setAccessible(true);

        // Get and print the current value of 'age'
        int currentAge = (int) ageField.get(person);
        System.out.println("Current Age: " + currentAge);

        // Modify the value of 'age'
        ageField.set(person, 30);

        // Get and print the modified value of 'age'
        int modifiedAge = (int) ageField.get(person);
        System.out.println("Modified Age: " + modifiedAge);
    }
}

