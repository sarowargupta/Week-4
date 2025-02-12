package com.week4.day2.set;
import java.util.*;

public class SetToSortedList {

    // Method to convert a set to a sorted list in ascending order
    public static List<Integer> convertSetToSortedList(Set<Integer> set) {
        // Convert set to list
        List<Integer> sortedList = new ArrayList<>(set);

        // Sort the list in ascending order
        Collections.sort(sortedList);

        //return sorted list
        return sortedList;
    }
    public static void main(String[] args) {
        // Define a HashSet of integers
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        // Convert the HashSet to a sorted list using the method
        List<Integer> sortedList = convertSetToSortedList(hashSet);

        // Print the sorted list
        System.out.println("Sorted List: " + sortedList);
    }

}

