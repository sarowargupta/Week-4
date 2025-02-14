package com.week4.day4;
import java.util.*;

//custom exception class
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
public class CustomException {
    public static void main(String[] args) {

        //create a scanner object
        Scanner sc = new Scanner(System.in);
        try{
            //enter valid age
            System.out.println("Enter age: ");
            int age = sc.nextInt();

            //call the method to validate age
            validateAge(age);


        } catch(InvalidAgeException e){

            //display custom exception message
            System.out.println("Custom Exception occurred " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Enter valid input for age: ");

        } finally {
            sc.close();
        }

    }
    //method to validate age
    public static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted! ");
        }
    }
}
