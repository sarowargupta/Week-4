package com.week4.day2.map;
import java.time.LocalDate;
import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class PolicyManagementSystem {
    private Map<String, InsurancePolicy> hashMapPolicies = new HashMap<>();
    private Map<String, InsurancePolicy> linkedHashMapPolicies = new LinkedHashMap<>();
    private Map<LocalDate, InsurancePolicy> treeMapPolicies = new TreeMap<>();

    // Add policy to all maps
    public void addPolicy(InsurancePolicy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }

    // Retrieve a policy by its number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        for (Map.Entry<LocalDate, InsurancePolicy> entry : treeMapPolicies.entrySet()) {
            if (!entry.getKey().isAfter(thirtyDaysLater)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByPolicyholder(String policyholderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : hashMapPolicies.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove policies that are expired
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        treeMapPolicies.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
        hashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        linkedHashMapPolicies.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
    }

    public static void main(String[] args) {
        PolicyManagementSystem manager = new PolicyManagementSystem();

        manager.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.of(2025, 3, 10), "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2026, 2, 25), "Auto", 3000));
        manager.addPolicy(new InsurancePolicy("P1003", "Charlie", LocalDate.of(2024, 12, 30), "Home", 7000));
        manager.addPolicy(new InsurancePolicy("P1004", "Alice", LocalDate.of(2024, 1, 15), "Health", 4000));  // Expired

        // Retrieve a policy by its number
        System.out.println("Policy P1002: " + manager.getPolicyByNumber("P1002"));

        // List policies expiring within 30 days
        System.out.println("\nPolicies Expiring Within 30 Days:");
        List<InsurancePolicy> expiringPolicies = manager.getPoliciesExpiringSoon();
        for (InsurancePolicy policy : expiringPolicies) {
            System.out.println(policy);
        }


        // List all policies for a specific policyholder
        System.out.println("\nPolicies for Alice:");
        List<InsurancePolicy> alicePolicies = manager.getPoliciesByPolicyholder("Alice");
        for (InsurancePolicy policy : alicePolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        Collection<InsurancePolicy> remainingPolicies = manager.hashMapPolicies.values();
        for (InsurancePolicy policy : remainingPolicies) {
            System.out.println(policy);
        }

    }
}