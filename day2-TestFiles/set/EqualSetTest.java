package com.week4.day2.set;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualSetTest {
    @Test
    public void testSetsAreEqual() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        assertTrue(set1.equals(set2));
    }
}
