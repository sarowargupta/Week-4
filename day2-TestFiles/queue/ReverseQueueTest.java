package com.week4.day2.queue;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseQueueTest {
    @Test
    void testReverseQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.add(30);
        expectedQueue.add(20);
        expectedQueue.add(10);

        ReverseQueue.reverseQueue(queue);

        assertEquals(expectedQueue, queue);
    }
}
