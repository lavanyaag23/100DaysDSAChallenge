/* Problem Statement
Given an array of candidate names where each name represents a vote cast for that candidate, determine the candidate who received the maximum number of votes. In case of a tie, return the lexicographically smallest candidate name.

Input Format
First line contains an integer n representing number of votes.
Second line contains n space-separated strings representing candidate names.

Output Format
Print the name of the winning candidate followed by the number of votes received.

Sample Input
13
john johnny jackie johnny john jackie jamie jamie john johnny jamie johnny john

Sample Output
john 4

Explanation
Both john and johnny receive 4 votes, 
but john is lexicographically smaller, so john is declared the winner. */

import java.util.*;

public class Question1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Integer> votes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            votes.put(name, votes.getOrDefault(name, 0) + 1);
        }

        String winner = "";
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {

            String candidate = entry.getKey();
            int count = entry.getValue();

            if (count > maxVotes ||
                (count == maxVotes && candidate.compareTo(winner) < 0)) {

                winner = candidate;
                maxVotes = count;
            }
        }

        System.out.println(winner + " " + maxVotes);

        sc.close();
    }
}