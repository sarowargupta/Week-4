package com.week4.day3;
import java.io.*;

public class FileHandling {

    // Method to copy content from source file to destination file
    public static void copyFile(String sourceFile, String destinationFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Attempt to open the source file
            File source = new File(sourceFile);
            if (!source.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            // Open input and output streams
            fis = new FileInputStream(source);
            fos = new FileOutputStream(destinationFile);

            // Read from source and write to destination
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully to: " + destinationFile);

        } catch (IOException e) {
            System.out.println("An error occurred during file handling: " + e.getMessage());

        } finally {
            // Close the streams in the finally block to ensure they are always closed
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Failed to close streams: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String sourceFile = "src/main/resources/source.txt";
        String destinationFile = "src/main/resources/destination.txt";

        //Call method copy the content of source file into destination file
        copyFile(sourceFile, destinationFile);
    }
}
