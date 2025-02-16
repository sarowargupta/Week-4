package com.week4.day6.annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)  // Makes it repeatable
@interface BugReport {
    String description();
}

// Use the repeatable annotation in a class
class Software {

    @BugReport(description = "NullPointerException occurs ")
    @BugReport(description = "Performance issue when handling large data")
    public void process() {
        System.out.println("Processing data...");
    }
}

//Retrieve and print all bug reports using Reflection API
public class BugReportAnnotation{
    public static void main(String[] args) throws NoSuchMethodException {
        // Get the class object
        Class<?> softwareClass = Software.class;

        // Get the method where annotation is applied
        Method method = softwareClass.getMethod("process");

        // Check if annotation is present
        if (method.isAnnotationPresent(BugReports.class)) {
            // Retrieve all annotations
            BugReports bugReports = method.getAnnotation(BugReports.class);

            // Print annotation details
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug: " + bug.description());
            }
        }

        // Call the annotated method
        Software software = new Software();
        software.process();
    }
}
