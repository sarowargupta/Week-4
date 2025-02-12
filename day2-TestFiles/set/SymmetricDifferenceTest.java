package com.week4.day2.set;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymmetricDifferenceTest {
    @Test
    public void testSymmetricDifference() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> expectedSymmetricDifference = new HashSet<>(Arrays.asList(1, 2, 4, 5));
        Set<Integer> actualSymmetricDifference = SymmetricDifference.symmetricDifference(set1, set2);

        assertEquals(expectedSymmetricDifference, actualSymmetricDifference);
    }
}
