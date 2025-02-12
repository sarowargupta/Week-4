package com.week4.day2.queue;
import java.util.*;

public class BinaryNumberUsingQueue{

    // Method to generate the first N binary numbers
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Start with "1"
        queue.add("1");

        for (int i = 0; i < N; i++) {
            // Remove the front of the queue
            String current = queue.remove();
            result.add(current);

            // Add "0" and "1" to the current string and enqueue them
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {

        int N = 5;

        //call the method
        List<String> binaryNumbers = generateBinaryNumbers(N);

        //print the result
        System.out.println("First " + N + " binary numbers: " + binaryNumbers);
    }
}


