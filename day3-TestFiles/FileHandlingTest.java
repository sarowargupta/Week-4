package com.week4.day3;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class FileHandlingTest {

    @Test
    void testFileCopy() {
        String sourceFile = "src/main/resources/source.txt";
        String destinationFile = "src/main/resources/destination.txt";

        try {
            File source = new File(sourceFile);
            if (!source.exists()) {
                java.nio.file.Files.write(source.toPath(), "This is a test file.".getBytes());
            }

            FileHandling.copyFile(sourceFile, destinationFile);

            File destination = new File(destinationFile);
            assertTrue(destination.exists(), "Destination file should exist after copying.");


        } catch (Exception e) {
            fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}
