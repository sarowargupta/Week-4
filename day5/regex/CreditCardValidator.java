package com.week4.day5.regex;
import java.util.regex.*;

public class CreditCardValidator {

    //method to check credit card is valid or not
    public static boolean isCreditCardValid(String cardNumber) {

        // Regular expressions for Visa and MasterCard
        String visaRegex = "^4[0-9]{15}$";
        String masterCardRegex = "^5[1-5][0-9]{14}$";

        //compile regex pattern
        Pattern visaPattern = Pattern.compile(visaRegex);
        Pattern masterCardPattern= Pattern.compile(masterCardRegex);

        if (cardNumber == null) {
            return false;
        }
        if (visaPattern.matcher(cardNumber).matches()) {
            return true;
        } else if (masterCardPattern.matcher(cardNumber).matches()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // Test cases
        String[] testCards = {
                "4111111111111111",
                "5500000000000004",
                "340000000000009",
                "6011000000000004",

        };

        //print result
        for (String card : testCards) {
            System.out.println("Card Number: " + card + " is " + (isCreditCardValid(card)?"valid":"invalid"));
        }
    }
}
