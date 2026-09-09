/* Problem Statement
Given an array of integers containing both positive and negative values, find the length of the longest contiguous subarray whose sum is equal to zero.

Input Format
An integer array arr[].

Output Format
Print the length of the longest subarray with sum equal to zero.

Sample Input
15 -2 2 -8 1 7 10 23

Sample Output
5

Explanation
The subarray [-2, 2, -8, 1, 7] has a sum of 0 and is the longest such subarray. */

import java.util.*;

public class Question1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int n = input.length;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;

        map.put(0, -1);

        for (int i = 0; i < n; i++) {

            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                int length = i - map.get(prefixSum);
                maxLength = Math.max(maxLength, length);
            } else {
                map.put(prefixSum, i);
            }
        }

        System.out.println(maxLength);

        sc.close();
    }
}