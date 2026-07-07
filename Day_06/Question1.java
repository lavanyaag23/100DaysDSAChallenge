/*Problem: Given a sorted array of n integers, remove duplicates in-place. Print only unique elements in order.

Input:
- First line: integer n
- Second line: n space-separated integers (sorted array)

Output:
- Print unique elements only, space-separated

Example:
Input:
6
1 1 2 2 3 3

Output:
1 2 3

Explanation: Keep first occurrence of each element: 1, 2, 3 */

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Handle empty array
        if (n == 0) {
            sc.close();
            return;
        }

        // Two-pointer approach
        int j = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }

        // Print unique elements
        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}