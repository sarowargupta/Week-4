package com.week4.day5.junit;

public class PerformanceTask {

    // Method that simulates a long-running task by sleeping for 3 seconds
    public String longRunningTask() {
        try {
            System.out.println("Task started...");
            // Sleep for 3 seconds
            Thread.sleep(3000);
            System.out.println("Task completed.");
        } catch (InterruptedException e) {
            System.out.println("Task was interrupted.");

        }
        return "Task completed!";
    }


    public static void main(String[] args) {
        //create object of performance task
        PerformanceTask task = new PerformanceTask();

        //call the method
        String result = task.longRunningTask();

        //print thr result
        System.out.println("Result: " + result);
    }


}
