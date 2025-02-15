package com.week4.day5.junit;

public class DatabaseConnection {
    private boolean isConnected;

    // Method to simulate connecting to a database
    public void connect() {
        System.out.println("Connecting to the database...");
        isConnected = true;
    }

    // Method to simulate disconnecting from the database
    public void disconnect() {
        System.out.println("Disconnecting from the database...");
        isConnected = false;
    }

    // Method to check the connection status
    public boolean isConnected() {
        return isConnected;
    }


    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        // Connect to the database
        databaseConnection.connect();
        System.out.println("Is connected: " + databaseConnection.isConnected());

        // Disconnect from the database
        databaseConnection.disconnect();
        System.out.println("Is connected: " + databaseConnection.isConnected());
    }
}
