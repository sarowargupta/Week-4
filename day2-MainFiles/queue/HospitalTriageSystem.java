package com.week4.day2.queue;
import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {

        return "(" + name + ", " + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        // PriorityQueue with a custom comparator to order patients by severity (descending)
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return Integer.compare(p2.severity, p1.severity);  // Higher severity first
            }
        });

        // Add patients to the triage queue
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        System.out.println("Order of treatment:");

        // Process patients in order of severity
        while (!triageQueue.isEmpty()) {
            Patient patient = triageQueue.remove();
            System.out.println(patient.name + " (Severity: " + patient.severity + ")");
        }
    }
}

