package com.week4.day5.junit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

class PerformanceTaskTest {

     PerformanceTask tester = new PerformanceTask();

    @Test
    @Timeout(value = 4, unit = TimeUnit.SECONDS)
    void testLongRunningTask() {
        String result = tester.longRunningTask();
        assertEquals("Task completed!", result, "The task should return 'Task completed!'");
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        // This will exceed 2 seconds, causing a failure
        tester.longRunningTask();
    }
}
