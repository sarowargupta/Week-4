package com.week4.day2.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackUsingQueueTest {
    @Test
    void testPushAndTop() {
        StackUsingQueue stack = new StackUsingQueue();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Verify the top element
        assertEquals(3, stack.top());
    }
    @Test
    void testPop() {
        StackUsingQueue stack = new StackUsingQueue();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop the top element and verify it
        assertEquals(3, stack.pop());

        // Verify the new top element
        assertEquals(2, stack.top());
    }


}
