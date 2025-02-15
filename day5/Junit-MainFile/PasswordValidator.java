package com.week4.day5.junit;

public class PasswordValidator {
    //method to check password is valid or not
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasUpperCase && hasDigit;
    }


    public static void main(String[] args) {
        //create object of password validator class
        PasswordValidator validator = new PasswordValidator();

        //example of test password
        String[] testPasswords = {"password", "Password1", "12345678", "Pass123", "Strong@123"};

        for (String password : testPasswords) {
            System.out.println("Password: " + password + " is " + (validator.isValidPassword(password) ? "Valid" : "Invalid"));
        }
    }
}


