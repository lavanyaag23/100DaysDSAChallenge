/*Problem: Given an array of integers, count the frequency of each distinct element and print the result.

Input:
- First line: integer n (size of array)
- Second line: n integers

Output:
- Print each element followed by its frequency in the format element:count

Example:
Input:
5
1 2 2 3 1

Output:
1:2 2:2 3:1 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        LinkedHashMap<Integer, Integer> freq = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }

        sc.close();
    }
}