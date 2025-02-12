package com.week4.day2.set;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            return false;
        } 
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate.format(formatter) +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagementSystem {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("HashSet Policies:");
        hashSet.forEach(System.out::println);
        System.out.println("\nLinkedHashSet Policies:");
        linkedHashSet.forEach(System.out::println);
        System.out.println("\nTreeSet Policies (sorted by expiry date):");
        treeSet.forEach(System.out::println);
    }

    public void displayPoliciesExpiringSoon(int days) {
        System.out.println("\nPolicies expiring within the next " + days + " days:");
        LocalDate today = LocalDate.now();
        LocalDate cutoffDate = today.plusDays(days);
        treeSet.stream()
                .filter(policy -> !policy.getExpiryDate().isAfter(cutoffDate))
                .forEach(System.out::println);
    }

    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with coverage type: " + coverageType);
        hashSet.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public void displayDuplicatePolicies() {
        System.out.println("\nDuplicate Policies based on policy numbers:");
        Set<String> policyNumbers = new HashSet<>();
        hashSet.stream()
                .filter(policy -> !policyNumbers.add(policy.getPolicyNumber()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Sample policies
        system.addPolicy(new Policy("P001", "John Doe", LocalDate.of(2025, 3, 15), "Health", 5000));
        system.addPolicy(new Policy("P002", "Jane Smith", LocalDate.of(2025, 2, 28), "Auto", 3000));
        system.addPolicy(new Policy("P003", "Alice Brown", LocalDate.of(2025, 4, 10), "Home", 7000));
        system.addPolicy(new Policy("P001", "John Doe", LocalDate.of(2025, 3, 15), "Health", 5000)); // Duplicate

        // Display all policies
        system.displayAllPolicies();

        // Display policies expiring within the next 30 days
        system.displayPoliciesExpiringSoon(30);

        // Display policies with specific coverage type
        system.displayPoliciesByCoverageType("Health");

        // Display duplicate policies
        system.displayDuplicatePolicies();
    }
}
