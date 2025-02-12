package com.week4.day2.queue;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    // Method to reverse the queue
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        // Remove the front element
        int element = queue.remove();

        // Recursive call to reverse the remaining queue
        reverseQueue(queue);

        // Add the element back to the queue
        queue.add(element);
    }

    public static void main(String[] args) {
        // Initialize a queue
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        //print the result
        System.out.println("Reversed Queue: " + queue);
    }
}
