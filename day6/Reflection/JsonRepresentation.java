package com.week4.day6.reflection;
import java.lang.reflect.Field;

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        // Get the class of the object
        Class<?> clazz = obj.getClass();

        // Use StringBuilder to construct the JSON string
        StringBuilder jsonBuilder = new StringBuilder("{");

        // Get all declared fields of the class
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

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

//example person class
class PersonClass {
    private String name = "John";
    private int age = 20;
}

public class JsonRepresentation {
    public static void main(String[] args) throws IllegalAccessException {

        //create object of person class
        PersonClass obj = new PersonClass();

        // Convert the object to JSON format
        String json = JsonSerializer.toJson(obj);

        // Print the JSON output
        System.out.println(json);
    }
}

