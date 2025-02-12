package com.week4.day2.list;

public class ElementFromEnd {

    // head of the list
    Node head;

    // Node class
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }

    // Function to find the Nth element from the end
    public String findNthFromEnd(int N) {
        if (head == null || N <= 0) {
            return "Invalid input";
        }

        Node first = head;
        Node second = head;

        // Move the first pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (first == null) {
                return "N is larger than the size of the list";
            }
            first = first.next;
        }

        // Move both pointers until the first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // The second pointer is now at the Nth element from the end
        return second.data;
    }

    // Function to add a new node to the list
    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public static void main(String[] args) {
        // Create a new linked list
        ElementFromEnd list = new ElementFromEnd();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // Find the 2nd element from the end
        int N = 2;

        // Call the method to get the result
        String result = list.findNthFromEnd(N);

        // Call the method to get the result
        System.out.println("The " + N + "th element from the end is: " + result);
    }
}
