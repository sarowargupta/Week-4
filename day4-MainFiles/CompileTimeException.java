package com.week4.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTimeException {
    //method to check file exist or not
    public static void checkFile(String fileName){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine())!=null){
                //print content of file
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            //Handle missing file
            System.out.println("file not found ");

        } catch (IOException e){
            //Handle IO exception
            System.out.println("IOException occurred: " + e.getMessage());

        }

    }
    public static void main(String[] args) {

        //file path
        String fileName = "src/main/resources/data.txt";

        //call the method to check file exist or not
        checkFile(fileName);

    }

}
