package com.week4.day6.annotation;

// Parent class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class OverrideAnnotation{
    public static void main(String[] args) {

        // Instantiate Dog
        Dog myDog = new Dog();

        // Call overridden method
        myDog.makeSound();
    }
}
