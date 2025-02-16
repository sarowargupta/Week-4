package com.week4.day6.annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

//Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

//Create a class with methods annotated with @LogExecutionTime
class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method is running...");
    }

    @LogExecutionTime
    public void slowMethod() throws InterruptedException {
        System.out.println("Slow method is running...");
        Thread.sleep(500);
    }
}

//Use Reflection API to measure execution time
public class LogExecutionTimeAnnotation{
    public static void main(String[] args) throws Exception {
        // Get the class object
        Class<?> testClass = PerformanceTest.class;
        PerformanceTest testInstance = new PerformanceTest();

        // Iterate over all declared methods
        for (Method method : testClass.getDeclaredMethods()) {
            // Check if the method is annotated with @LogExecutionTime
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                // Measure execution time
                long startTime = System.nanoTime();
                method.invoke(testInstance);
                long endTime = System.nanoTime();

                // Calculate and print execution time
                long executionTime = (endTime - startTime) / 1_000_000;
                System.out.println("Execution time of " + method.getName() + ": " + executionTime + " ms");
                System.out.println();
            }
        }
    }
}
