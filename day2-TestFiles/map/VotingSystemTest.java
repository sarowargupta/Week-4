package com.week4.day2.map;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class VotingSystemTest {

    private VotingSystem votingSystem;

    @BeforeEach
    void setUp() {
        votingSystem = new VotingSystem();
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
    }

    @Test
    void testCastVote() {
        Map<String, Integer> voteCount = votingSystem.getVoteCount();
        assertEquals(2, voteCount.get("Alice"));

        assertEquals(2, voteCount.get("Bob"));

        assertEquals(1, voteCount.get("Charlie"));
    }

    @Test
    void testDisplayVoteOrder() {
        Map<String, Integer> voteOrder = votingSystem.getVoteOrder();
        List<String> expectedOrder = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> actualOrder = new ArrayList<>(voteOrder.keySet());

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void testDisplaySortedResults() {
        votingSystem.displaySortedResults();
        Map<String, Integer> sortedResults = votingSystem.getSortedResults();

        List<String> expectedSortedKeys = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> actualSortedKeys = new ArrayList<>(sortedResults.keySet());

        assertEquals(expectedSortedKeys, actualSortedKeys);
    }
}

