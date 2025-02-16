package com.week4.day6.annotation;
import java.util.ArrayList;

public class SuppressWarningAnnotation {

    // Suppress unchecked warnings
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        //ArrayList without generics
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(100); // No type safety

        // Printing the list
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
