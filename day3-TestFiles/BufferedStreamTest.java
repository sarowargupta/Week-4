package com.week4.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class BufferedStreamTest {

    private static final String sourceFile = "src/main/resources/stream.txt";
    private static final String destBuffered= "src/main/resources/buffered.txt";
    private static final String destUnbuffered = "src/main/resources/unbuffered.txt";
    private static final long fileSize = 5L * 1024 * 1024; // 5MB for testing

    @BeforeEach
    void setUp() throws IOException {
        // Create a test source file with sample content
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(sourceFile))) {
            byte[] data = new byte[4096];
            for (long i = 0; i < fileSize / 4096; i++) {
                bos.write(data);
            }
        }
    }

    @Test
    void testCopyFileWithBuffer() {
        long timeTaken = BufferedStream.copyWithBufferedStreams(sourceFile,destBuffered);
        File copiedFile = new File(destBuffered);
        assertTrue(copiedFile.exists(), "Buffered copy should create a file");
        assertTrue(timeTaken > 0, "Time taken should be positive");
    }

    @Test
    void testCopyFileWithoutBuffer() {
        long timeTaken = BufferedStream.copyWithUnbufferedStreams(sourceFile, destUnbuffered);
        File copiedFile = new File(destUnbuffered);
        assertTrue(copiedFile.exists(), "Unbuffered copy should create a file");
        assertTrue(timeTaken > 0, "Time taken should be positive");
    }


}