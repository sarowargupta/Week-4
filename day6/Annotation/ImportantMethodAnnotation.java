package com.week4.day6.annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

//Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

//Use the annotation in a class
class Operations {

    @ImportantMethod(level = "LOW")
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod  // Uses default level = "HIGH"
    public void saveData() {
        System.out.println("Saving data...");
    }

}

//Retrieve and print annotated methods using Reflection API
public class ImportantMethodAnnotation {
    public static void main(String[] args) throws Exception {
        // Get the class object
        Class<?> operationsClass = Operations.class;

        // Iterate over all declared methods
        for (Method method : operationsClass.getDeclaredMethods()) {
            // Check if the method is annotated with @ImportantMethod
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                // Retrieve the annotation
                ImportantMethod important = method.getAnnotation(ImportantMethod.class);

                // Print method name and its importance level
                System.out.println("Important Method: " + method.getName() + ", Level: " + important.level());
            }
        }

        // Call the annotated methods
        Operations ops = new Operations();
        ops.processData();
        ops.saveData();
    }
}
