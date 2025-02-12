package com.week4.day2.list;
import java.util.*;

public class RemoveDuplicate {
    //method to remove duplicate and also maintaining the original order
    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        //return list
        return result;
    }

    public static void main(String[] args) {
        //create an object of list and store array
        List<Integer> inputList = Arrays.asList(3, 1, 2, 2, 3, 4);

        //call method to remove duplicate and store it in result
        List<Integer> result = removeDuplicates(inputList);

        //print result
        System.out.println("List without Duplicates: " + result);
    }
}

