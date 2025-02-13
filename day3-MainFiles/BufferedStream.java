package com.week4.day3;
import java.io.*;

public class BufferedStream{

    //method to copy large file by using unbuffered Stream
    public static long copyWithUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    //method to copy large file by using buffered Stream
    public static long copyWithBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            // 4 KB buffer
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
    public static void main(String[] args) {
        String sourceFile = "src/main/resources/stream.txt";
        String destBuffered = "src/main/resources/buffered.txt";
        String destUnbuffered = "src/main/resources/Unbuffered.txt";

        // Copy using Buffered Streams
        long bufferedTime = copyWithBufferedStreams(sourceFile, destBuffered);
        System.out.println("Buffered Stream Time: " + bufferedTime + " ns");

        // Copy using Unbuffered Streams
        long unbufferedTime = copyWithUnbufferedStreams(sourceFile, destUnbuffered);
        System.out.println("Unbuffered Stream Time: " + unbufferedTime + " ns");
    }

}
