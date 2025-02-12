package com.week4.day2.list;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    // Method to reverse a List (works for both ArrayList and LinkedList)
    public static <T> void reverseList(List<T> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            // Swap elements at left and right indices
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Create an Arraylist object
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Original ArrayList: " + arrayList);
        //call the method to revere list
        reverseList(arrayList);

        //print the result
        System.out.println("Reversed ArrayList: " + arrayList);

        // Example with LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("\nOriginal LinkedList: " + linkedList);
        //call the method to reverse list
        reverseList(linkedList);

        //print the result
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}

