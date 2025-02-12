package com.week4.day2.set;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubsetTest {
    @Test
    public void testSubset() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        assertTrue(Subset.isSubset(set1, set2));
    }
}
