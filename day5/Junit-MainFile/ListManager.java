package com.week4.day5.junit;
import java.util.*;

public class ListManager {

    // Method to add an element to the list
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Method to remove an element from the list
    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));  // Removes the first occurrence of the element
    }

    // Method to get the size of the list
    public static int getSize(List<Integer> list) {
        return list.size();
    }

    public static void main(String[] args) {
        List<Integer> List = new ArrayList<>();

        // Testing addElement method
        addElement(List, 10);
        addElement(List, 20);
        addElement(List, 30);
        System.out.println("List after adding elements: " + List);

        // Testing removeElement method
        removeElement(List, 20);
        System.out.println("List after removing element 20: " + List);

        // Testing getSize method
        System.out.println("Size of the list: " + getSize(List));
    }
}

