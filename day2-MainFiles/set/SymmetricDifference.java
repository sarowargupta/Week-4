package com.week4.day2.set;
import java.util.*;

public class SymmetricDifference {

    // Function to compute the symmetric difference of two sets
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        // Union of set1 and set2
        result.addAll(set2);

        // Intersection of set1 and set2
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Remove the intersection from the union
        result.removeAll(intersection);
        return result;
    }
    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Compute and print the symmetric difference
        Set<Integer> symmetricDifferenceResult = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDifferenceResult);
    }

}

