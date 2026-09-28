/*Problem: Sort array of non-negative integers using counting sort.
Find max, build freq array, compute prefix sums, build output. */

import java.util.*;

public class Question1 {

    static void countingSort(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + 1];

        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 1; i <= max; i++) {
            freq[i] += freq[i - 1];
        }

        int[] output = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[freq[arr[i]] - 1] = arr[i];
            freq[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        countingSort(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}