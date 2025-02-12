package com.week4.day2.list;
import java.util.*;

public class FrequencyOfElement{
    //method to find count frequency
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        //return frequency
        return frequencyMap;
    }

    public static void main(String[] args) {
        //create an object of list type which contains array as list
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange");

        //call the method count the frequency of given array
        Map<String, Integer> result = countFrequency(inputList);

        //input of array as list
        System.out.println("Input: " + inputList);

        //print the result of frequency
        System.out.println("Frequency Count: " + result);
    }
}




