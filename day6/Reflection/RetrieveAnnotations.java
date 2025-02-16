package com.week4.day6.reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Apply the annotation to a class
@Author(name = "Author Name")
class Example {
    public void display() {
        System.out.println("ExampleClass method executed");
    }
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        // Get the class object
        Class<?> obj = Example.class;

        // Retrieve and display the annotation
        if (obj.isAnnotationPresent(Author.class)) {

            // Retrieve the annotation
            Author author = obj.getAnnotation(Author.class);

            // Display annotation value
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No Author annotation present");
        }
    }
}
