package com.week4.day2.set;
import java.util.*;

public class EqualSet {
    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        // Check if the sets are equal
        boolean areEqual = set1.equals(set2);

        // Print the result
        System.out.println("Are the sets equal? " + areEqual);
    }
}

