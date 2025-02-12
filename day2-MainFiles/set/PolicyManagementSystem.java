package com.week4.day2.set;
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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        int dateComparison = this.expiryDate.compareTo(other.expiryDate);
        if (dateComparison != 0) {
            return dateComparison;
        }
        return this.policyNumber.compareTo(other.policyNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
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
    private List<InsurancePolicy> policyList = new ArrayList<>();

    // Add a policy to the list
    public void addPolicy(InsurancePolicy policy) {
        policyList.add(policy);
    }

    // Get all unique policies
    public Set<InsurancePolicy> getAllPolicies() {
        return new HashSet<>(policyList);
    }

    // Get policies expiring within the next 30 days
    public Set<InsurancePolicy> getExpiringSoonPolicies() {
        Set<InsurancePolicy> expiringPolicies = new TreeSet<>();
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        for (InsurancePolicy policy : policyList) {
            if (!policy.getExpiryDate().isAfter(thirtyDaysLater)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // Get policies by coverage type
    public Set<InsurancePolicy> getPoliciesByCoverageType(String coverageType) {
        Set<InsurancePolicy> filteredPolicies = new HashSet<>();
        for (InsurancePolicy policy : policyList) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    // Find duplicate policies based on policy numbers
    public Set<InsurancePolicy> getDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        Set<InsurancePolicy> duplicatePolicies = new HashSet<>();

        for (InsurancePolicy policy : policyList) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        for (InsurancePolicy policy : policyList) {
            if (policyCount.get(policy.getPolicyNumber()) > 1) {
                duplicatePolicies.add(policy);
            }
        }
        return duplicatePolicies;
    }

    public static void main(String[] args) {
        PolicyManagementSystem manager = new PolicyManagementSystem();

        manager.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.of(2025, 3, 10), "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2024, 2, 25), "Auto", 3000));
        manager.addPolicy(new InsurancePolicy("P1003", "Charlie", LocalDate.of(2024, 12, 30), "Home", 7000));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2024, 2, 25), "Auto", 3000));  // Duplicate

        System.out.println("All Policies:");
        System.out.println(manager.getAllPolicies());

        System.out.println("\nPolicies Expiring Soon (Within 30 Days):");
        System.out.println(manager.getExpiringSoonPolicies());

        System.out.println("\nPolicies with Coverage Type 'Auto':");
        System.out.println(manager.getPoliciesByCoverageType("Auto"));

        System.out.println("\nDuplicate Policies:");
        System.out.println(manager.getDuplicatePolicies());
    }
}
