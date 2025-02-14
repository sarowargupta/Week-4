package com.week4.day3;
import java.io.*;

public class ConvertImageToByteArray {

    // Method to convert an image file to a byte array
    public static byte[] imageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error converting image to byte array: " + e.getMessage());
            return null;
        }
    }

    // Method to write a byte array back to an image file
    public static void byteArrayToImage(byte[] imageData, String outputImagePath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputImagePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image written successfully to " + outputImagePath);
        } catch (IOException e) {
            System.out.println("Error writing byte array to image: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceImagePath = "src/main/resources/image2.png";
        String outputImagePath = "src/main/resources/image.jpg";

        // Convert image to byte array
        byte[] imageData = imageToByteArray(sourceImagePath);
        if (imageData != null) {
            System.out.println("Image converted to byte array successfully. Size: " + imageData.length + " bytes");

            // Convert byte array back to image
            byteArrayToImage(imageData, outputImagePath);
        }
    }
}

