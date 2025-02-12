package com.week4.day2.queue;

public class CircularBufferSimulation {
    private int[] buffer;

    // Points to the oldest element
    private int head = 0;

    // Points to the next available slot
    private int tail = 0;

    // Number of elements in the buffer
    private int size = 0;

    // Maximum capacity of the buffer
    private int capacity;

    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Insert an element into the circular buffer
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Buffer is full. Overwriting the oldest element: " + buffer[head]);

            // Move head to overwrite the oldest element
            head = (head + 1) % capacity;
        } else {
            size++;
        }
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
    }
    // Get the current state of the buffer as an array
    public int[] getBufferState() {
        int[] state = new int[capacity];
        for (int i = 0; i < size; i++) {
            state[i] = buffer[(head + i) % capacity];
        }
        return state;
    }

    // Display the elements in the buffer
    public void displayBuffer() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        CircularBufferSimulation circularBuffer = new CircularBufferSimulation(3);

        // Insert elements into the buffer
        circularBuffer.insert(1);
        circularBuffer.insert(2);
        circularBuffer.insert(3);
        circularBuffer.displayBuffer();

        // Insert another element, overwriting the oldest one
        circularBuffer.insert(4);
        circularBuffer.displayBuffer();

    }
}
