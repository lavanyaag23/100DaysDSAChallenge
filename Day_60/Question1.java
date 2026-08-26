/* Problem Statement:
Check whether a given binary tree satisfies the Min-Heap property.

Input Format:
- First line contains integer N
- Second line contains level-order traversal

Output Format:
- Print YES if valid Min-Heap, otherwise NO

Example:
Input:
7
1 3 5 7 9 8 10

Output:
YES

Explanation:
Each parent node must be smaller than its children. */

import java.util.*;

public class Question1 {

    static boolean isMinHeap(int[] arr, int n) {
        // Check every parent node
        for (int i = 0; i <= (n - 2) / 2; i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Parent must be <= left child
            if (left < n && arr[i] > arr[left]) {
                return false;
            }

            // Parent must be <= right child
            if (right < n && arr[i] > arr[right]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(isMinHeap(arr, n) ? "YES" : "NO");

        sc.close();
    }
}