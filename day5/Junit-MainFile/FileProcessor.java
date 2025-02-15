package com.week4.day5.junit;
import java.io.*;
public class FileProcessor {

    //method to write to file
        public void writeToFile(String filename, String content) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(content);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }

        //method to read from file
        public String readFromFile(String filename) {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            } catch (IOException e) {
                System.err.println("Error reading from file: " + e.getMessage());
            }
            return content.toString().trim();
        }
        public static void main(String[] args) {
            FileProcessor processor = new FileProcessor();

            //file path
            String filename = "src/main/resources/test.txt";

            // Writing to file
            processor.writeToFile(filename, "Hello, this is a test file.");

            // Reading from file
            String content = processor.readFromFile(filename);
            System.out.println("File Content: " + content);
        }

}
