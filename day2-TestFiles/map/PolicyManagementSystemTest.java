package com.week4.day2.map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolicyManagementSystemTest {
    private PolicyManagementSystem manager;

    @BeforeEach
    public void setUp() {
        manager = new PolicyManagementSystem();
        manager.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.of(2025, 3, 10), "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2026, 2, 25), "Auto", 3000));
        manager.addPolicy(new InsurancePolicy("P1003", "Charlie", LocalDate.of(2024, 12, 30), "Home", 7000));

        // Expired
        manager.addPolicy(new InsurancePolicy("P1004", "Alice", LocalDate.of(2023, 12, 5), "Health", 4000));
    }

    @Test
    public void testAddAndRetrievePolicy() {
        InsurancePolicy policy = manager.getPolicyByNumber("P1001");

        assertEquals("Alice", policy.getPolicyholderName());
    }

    @Test
    public void testGetPoliciesExpiringSoon() {
        assertEquals(3, manager.getPoliciesExpiringSoon().size());
    }

    @Test
    public void testGetPoliciesByPolicyholder() {
        assertEquals(2, manager.getPoliciesByPolicyholder("Alice").size());
    }

    @Test
    public void testRemoveExpiredPolicies() {
        manager.removeExpiredPolicies();
        assertEquals(null,manager.getPolicyByNumber("P1004"));
    }
}
