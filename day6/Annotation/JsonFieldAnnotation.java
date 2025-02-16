package com.week4.day6.annotation;
import java.lang.annotation.*;
import java.lang.reflect.Field;

//Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// Create a User class with @JsonField annotations
class Person {

    @JsonField(name = "user_name")
    private String username;

    public Person(String username) {
        this.username = username;

    }
}

//Create a Serializer to Convert Objects to JSON
class JsonSerializer {

    public static String serialize(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        // Use StringBuilder to construct the JSON string
        StringBuilder jsonBuilder = new StringBuilder("{");

        // Get all declared fields of the class
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            java.lang.reflect.Field field = fields[i];

            // Allow access to private fields
            field.setAccessible(true);

            // Append field name and its value to the JSON string
            jsonBuilder.append("\"").append(field.getName()).append("\": ")
                    .append("\"").append(field.get(obj)).append("\"");

            // Add a comma separator between key-value pairs, except for the last pair
            if (i < fields.length - 1) {
                jsonBuilder.append(", ");
            }
        }
        // Close the JSON structure
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}

//Test the JSON Serialization
public class JsonFieldAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        Person user = new Person("Alice");

        // Serialize User to JSON
        String json = JsonSerializer.serialize(user);

        // Print the JSON output
        System.out.println(json);
    }
}

