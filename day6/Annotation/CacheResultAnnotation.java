package com.week4.day6.annotation;
import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

//Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

//Create a class with a computationally expensive method
class ExpensiveCalculator {

    // Cache to store results
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        // Check if result is already in cache
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }

        // Simulate an expensive computation
        System.out.println("Computing square for: " + number);
        int result = number * number;

        // Store result in cache
        cache.put(number, result);
        return result;
    }
}

// Test the caching system
public class CacheResultAnnotation {
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calculator = new ExpensiveCalculator();

        // First-time computation (stores in cache)
        System.out.println("Result: " + calculator.computeSquare(5));

        // Second-time call with same input (retrieves from cache)
        System.out.println("Result: " + calculator.computeSquare(5));

        // Another computation (stores in cache)
        System.out.println("Result: " + calculator.computeSquare(10));

        // Reusing cached value
        System.out.println("Result: " + calculator.computeSquare(10));
    }
}
