package com.week4.day2.list;
import java.util.*;

public class RotateElement {

    //method to rotate array an array with given index
    public static List<Integer> rotateList(List<Integer> list, int positions) {
        int size = list.size();
        if (size == 0){

            // No rotation needed
            return list;
        }

        positions = positions % size;
        if (positions < 0) {

            // Convert negative rotation to positive
            positions += size;
        }

        List<Integer> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(positions, size));
        rotatedList.addAll(list.subList(0, positions));

        //return rotated list
        return rotatedList;
    }

    public static void main(String[] args) {
        //create an object of list and store array as list
        List<Integer> inputList = Arrays.asList(10, 20, 30, 40, 50);

        //index from array rotate
        int rotateBy = 2;

        //call the method to rotate array
        List<Integer> result = rotateList(inputList, rotateBy);

        //print the result after rotation
        System.out.println("Rotated List: " + result);
    }
}
