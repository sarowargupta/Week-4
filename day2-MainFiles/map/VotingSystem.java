package com.week4.day2.map;
import java.util.*;

public class VotingSystem {
    // HashMap to store votes
    private Map<String, Integer> voteCount;

    // TreeMap for sorted results
    private Map<String, Integer> sortedResults;

    // LinkedHashMap to maintain insertion order of votes
    private Map<String, Integer> voteOrder;

    public VotingSystem() {
        voteCount = new HashMap<>();
        sortedResults = new TreeMap<>();
        voteOrder = new LinkedHashMap<>();
    }

    // Method to cast a vote for a candidate
    public void castVote(String candidate) {
        // Increment the vote count for the candidate in voteCount
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        // Update voteOrder to maintain the order in which votes are cast
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    // Method to display the total vote count for each candidate
    public void displayVoteCount() {
        System.out.println("Total Votes for Each Candidate:");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Method to display the results in insertion order using LinkedHashMap
    public void displayVoteOrder() {
        System.out.println("Votes in the order they were cast:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Method to display the results in sorted order using TreeMap
    public void displaySortedResults() {
        sortedResults.putAll(voteCount);  // Copy all entries from voteCount to sortedResults
        System.out.println("Votes in sorted order by candidate name:");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
    // Getter methods for testing
    public Map<String, Integer> getVoteCount() {
        return voteCount;
    }

    public Map<String, Integer> getVoteOrder() {
        return voteOrder;
    }

    public Map<String, Integer> getSortedResults() {
        sortedResults.putAll(voteCount);
        return sortedResults;
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Simulate casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");

        // Display total vote counts
        votingSystem.displayVoteCount();
        System.out.println();

        // Display vote order
        votingSystem.displayVoteOrder();
        System.out.println();

        // Display sorted results
        votingSystem.displaySortedResults();
    }
}
