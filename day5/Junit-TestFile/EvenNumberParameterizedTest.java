package com.week4.day5.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenNumberParameterizedTest {


    @Test
    public void testIsEvenWithEvenNumber() {
        assertTrue(EvenNumberParameterized.isEven(2));
        assertTrue(EvenNumberParameterized.isEven(10));
    }

    @Test
    public void testIsEvenWithOddNumber() {
        assertFalse(EvenNumberParameterized.isEven(3));
        assertFalse(EvenNumberParameterized.isEven(11));
    }
    @Test
    public void testIsEvenWithMultipleNumber(){
        int[] testNumbers = {2, 4, 6, 7, 9};
        for(int numbers:testNumbers){
            if(numbers%2==0){
                assertTrue(EvenNumberParameterized.isEven(numbers));
            } else {
                assertFalse(EvenNumberParameterized.isEven(numbers));
            }
        }
    }



}
