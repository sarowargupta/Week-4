package com.week4.day5.junit;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    FileProcessor processor = new FileProcessor();
    private final String testFilename = "src/main/resources/test.txt";


    @Test
    void testWriteAndReadFile() {
        String content = "JUnit test content.";
        processor.writeToFile(testFilename, content);

        String readContent = processor.readFromFile(testFilename);

        // Assert the content is correctly written and read
        assertEquals(content, readContent);
    }

    @Test
    void testFileExistsAfterWriting() {
        processor.writeToFile(testFilename, "Checking file existence.");

        File file = new File(testFilename);

        assertTrue(file.exists());
    }

    @Test
    void testHandlingOfIOExceptionForNonExistentFile() {
        String nonExistentFile = "nonexistent.txt";
        String content = processor.readFromFile(nonExistentFile);

        assertEquals("", content, "Reading a non-existent file should return an empty string.");
    }

}
