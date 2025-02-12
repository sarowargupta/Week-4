package com.week4.day2.set;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnionAndIntersectionTest {
    @Test
    public void testUnion() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> expectedUnion = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> actualUnion = UnionAndIntersection.union(set1, set2);

        assertEquals(expectedUnion, actualUnion);
    }
    @Test
    public void testIntersection() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> expectedIntersection = new HashSet<>(Collections.singletonList(3));
        Set<Integer> actualIntersection = UnionAndIntersection.intersection(set1, set2);

        assertEquals(expectedIntersection, actualIntersection);
    }

}
