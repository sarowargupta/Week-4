package com.week4.day6.reflection;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Sample class to be mapped
class ExampleClass {
    private String name;
    private int age;

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomObjectMapperProgram {

    // Generic method to populate object from map
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        // Create a new instance of the given class
        T instance = clazz.getDeclaredConstructor().newInstance();

        // Iterate over map and set values using Reflection
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            // Get field from the class
            Field field = clazz.getDeclaredField(fieldName);

            // Allow modification of private fields
            field.setAccessible(true);

            // Set field value
            field.set(instance, fieldValue);
        }

        // Return populated object
        return instance;
    }

    public static void main(String[] args) throws Exception {
        // Create a map with field values
        Map<String, Object> personData = new HashMap<>();
        personData.put("name", "Alice");
        personData.put("age", 30);

        // Convert map to object
        ExampleClass person = toObject(ExampleClass.class, personData);

        // Display the populated object
        person.display();
    }
}
