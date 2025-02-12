package com.week4.day2.queue;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HospitalTriageSystemTest {
    @Test
    void testPatientOrder() {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        List<String> processedOrder = new ArrayList<>();

        while (!triageQueue.isEmpty()) {
            processedOrder.add(triageQueue.remove().name);
        }

        List<String> expectedOrder = Arrays.asList("Alice", "John", "Bob");

        assertEquals(expectedOrder, processedOrder);
    }

}
