package com.week4.day6.reflection;
import java.lang.reflect.Field;

//Configuration class
class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
}

public class AccessModifyStaticFields {
    public static void main(String[] args) throws Exception {
        // Get the Configuration class
        Class<?> configClass = Configuration.class;

        // Access the private static field 'API_KEY'
        Field apiKeyField = configClass.getDeclaredField("API_KEY");

        //allow access
        apiKeyField.setAccessible(true);

        // Modify the value of 'API_KEY'
        apiKeyField.set(null, "NEW_SECURE_KEY");

        // Retrieve and print the modified value
        String modifiedKey = (String) apiKeyField.get(null);
        System.out.println("Modified API_KEY: " + modifiedKey);
    }
}
