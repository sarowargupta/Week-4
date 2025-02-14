package com.week4.day3;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputToFileTest {

    @Test
    void testSaveDataToFile() {
        String fileName = "src/main/resources/Console.txt";
        String sampleData = "Name: John Doe\nAge: 25\nFavorite Language: Java\n";

        // Call the method to save data to the file
        boolean result = InputFromConsole.saveDataToFile(fileName, sampleData);

        // Check if the file was created
        File file = new File(fileName);
        assertTrue(result, "The saveDataToFile method should return true.");
        assertTrue(file.exists(), "The file should be created.");

    }
}

