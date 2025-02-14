package com.week4.day4;
import java.util.*;
public class MultipleCatchBlocks {
public static void main(String[] args) {

    //create a scanner object
    Scanner sc = new Scanner(System.in);
    try{
        //enter size of an array
        System.out.println("Enter size of an array");
        int size = sc.nextInt();

        //accept integer array
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        //accept index from the user
        System.out.println("enter index to retrieve the value at that index");
        int index = sc.nextInt();

        //call the method to get the value and store
        int value = getValueAtIndex(arr,index);
        System.out.println("Value at " + index + " is " + value );

    }   catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index!");
    }    catch (NullPointerException e){
            System.out.println("Array is not initialized!");
    }    catch (Exception e) {
            System.out.println("enter valid array");
    }   finally {
            sc.close();
    }

  }
   //method  to get value at index
    public static int getValueAtIndex(int[] arr,int index){
          return arr[index];
    }
  }
