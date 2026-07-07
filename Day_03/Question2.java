// Platform: GeeksforGeeks
// Problem: Missing Number
// Difficulty: Easy

import java.util.Scanner;

public class Question2 {

    public static int missingNumber(int[] arr) {
        int n = arr.length + 1;

        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size (n - 1)
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Input array elements
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Output missing number
        System.out.println(missingNumber(arr));

        sc.close();
    }
}