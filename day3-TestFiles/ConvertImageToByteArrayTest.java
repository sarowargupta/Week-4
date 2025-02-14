package com.week4.day3;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class ConvertImageToByteArrayTest {

    private static final String sourceImagePath = "src/main/resources/image (2).png";
    private static final String otputImagePath = "src/main/resources/image.jpg";

    @Test
    void testImageToByteArray() {
        byte[] imageData = ConvertImageToByteArray.imageToByteArray(sourceImagePath);
        assertNotNull(imageData, "Image data should not be null");
    }

    @Test
    void testByteArrayToImage() {
        byte[] imageData = ConvertImageToByteArray.imageToByteArray(sourceImagePath);
        assertNotNull(imageData, "Image data should not be null");

        ConvertImageToByteArray.byteArrayToImage(imageData, otputImagePath);

        File outputFile = new File(otputImagePath);
        assertTrue(outputFile.exists(), "Output image file should exist");
    }
}

