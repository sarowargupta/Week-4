package com.week4.day2.set;
import java.util.*;

public class UnionAndIntersection{
    // Method to compute the union of two sets
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    // Method to compute the intersection of two sets
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Compute and print union
        Set<Integer> unionResult = union(set1, set2);
        System.out.println("Union: " + unionResult);

        // Compute and print intersection
        Set<Integer> intersectionResult = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionResult);
    }
}
