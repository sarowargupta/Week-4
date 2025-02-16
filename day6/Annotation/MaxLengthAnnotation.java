package com.week4.day6.annotation;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Create a User class with validation logic
class User {

    @MaxLength(10) // Restrict username to a max of 10 characters
    public String username;

    // Constructor with validation logic
    public User(String username) {
        validateMaxLength(this, username);
        this.username = username;
    }

    //Validate field length using Reflection
    private void validateMaxLength(Object obj, String value) {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();

                if (value.length() > maxLength) {
                    throw new IllegalArgumentException("Error: " + field.getName() +
                            " exceeds max length of " + maxLength + " characters.");
                }
            }
        }
    }
    @Override
    public String toString() {
        return  username;
    }

}

//Test the validation
public class MaxLengthAnnotation {
    public static void main(String[] args) {
        // Valid username
        User user1 = new User("Bobbie");
        System.out.println("User created successfully: " + user1);

        // Invalid username (exceeds 10 characters)
        User user2 = new User("VeryLongUsername");
        System.out.println("User created successfully: " + user2);
    }
}
