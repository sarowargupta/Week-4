package com.week4.day3;
import java.io.*;

public class PipeStream {
    //Method to read data from piped Input Stream
    public static void readData(PipedInputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reader: Received - " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
    //Method to write data into piped Output Stream
    public static void writeData(PipedOutputStream outputStream) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            String[] messages = {
                    "Hello from the writer thread!",
                    "Piped streams are useful for inter-thread communication.",
                    "This is the last message."
            };

            for (String message : messages) {
                writer.write(message + "\n");
                writer.flush();
                System.out.println("Writer: Sent - " + message);
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream();

        try {
            inputStream.connect(outputStream);

            Thread writerThread = new Thread(() -> writeData(outputStream));
            writerThread.start();

            Thread readerThread = new Thread(() -> readData(inputStream));
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Error connecting piped streams: " + e.getMessage());
        }
    }

}



