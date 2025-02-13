package com.week4.day2.map;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankingSystemTest {

    private BankingSystem bank;

    @BeforeEach
    void setUp() {
        bank = new BankingSystem();
        bank.createAccount(101, 1000.00);
        bank.createAccount(102, 500.00);
        bank.createAccount(103, 1500.00);
    }

    @Test
    void testCreateAccount() {
        bank.createAccount(104, 750.00);
        assertEquals(750.00, bank.getBalance(104), "Balance should be 750.00");
    }

    @Test
    void testRequestWithdrawal() {
        bank.requestWithdrawal(101, 200.00);
        bank.processWithdrawals();
        assertEquals(800.00, bank.getBalance(101), "Balance should be 800.00 after withdrawal");
    }



    @Test
    void testDisplayAccountsSortedByBalance() {
        bank.createAccount(104, 750.00);
        bank.displayAccountsSortedByBalance();

    }


}
