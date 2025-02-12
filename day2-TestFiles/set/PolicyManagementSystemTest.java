package com.week4.day2.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolicyManagementSystemTest {
    private PolicyManagementSystem manager;

    @BeforeEach
    void setUp() {
        manager = new PolicyManagementSystem();
        manager.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.of(2025, 3, 10), "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2024, 2, 25), "Auto", 3000));
        manager.addPolicy(new InsurancePolicy("P1003", "Charlie", LocalDate.of(2024, 12, 30), "Home", 7000));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2024, 2, 25), "Auto", 3000));  // Duplicate
    }

    @Test
    void testGetAllPolicies() {
        assertEquals(3, manager.getAllPolicies().size(), "Should contain 3 unique policies.");
    }

    @Test
    void testGetExpiringSoonPolicies() {
        assertEquals(3, manager.getExpiringSoonPolicies().size(), "Should contain 1 policy expiring within 30 days.");
    }

    @Test
    void testGetPoliciesByCoverageType() {
        assertEquals(1, manager.getPoliciesByCoverageType("Auto").size(), "Should contain 1 Auto policy.");
    }

    @Test
    void testGetDuplicatePolicies() {
        assertEquals(1, manager.getDuplicatePolicies().size(), "Should detect 1 duplicate policy.");
    }
}


