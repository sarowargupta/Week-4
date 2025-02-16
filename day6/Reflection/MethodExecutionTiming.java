package com.week4.day6.reflection;
import java.lang.reflect.Method;

class MethodTimer {

    // Method to measure execution time of any method using Reflection
    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Class<?> objClass = obj.getClass();
        Method method = objClass.getMethod(methodName);

        // Start time
        long startTime = System.nanoTime();

        // Invoke method dynamically
        method.invoke(obj);

        // End time
        long endTime = System.nanoTime();
        System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) + " nanoseconds");
    }
}

// Sample class with methods
class SampleClass {
    public void fastMethod() {
        System.out.println("Fast method executed");
    }

    public void slowMethod() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Slow method executed");
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {

        //create object of sample class
        SampleClass sample = new SampleClass();

        // Measure execution time for both methods
        MethodTimer.measureExecutionTime(sample, "fastMethod");
        MethodTimer.measureExecutionTime(sample, "slowMethod");
    }
}

