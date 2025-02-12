package com.week4.day2.queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class CircularBufferSimulationTest {

    @Test
    void testInsertWithOverwrite() {
        CircularBufferSimulation buffer = new CircularBufferSimulation(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        int[] result = {2,3,4};
        assertArrayEquals(result, buffer.getBufferState());
    }


}