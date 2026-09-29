/* Problem: Given n real numbers in [0,1), sort using bucket sort algorithm.
Distribute into buckets, sort each, concatenate. */

import java.util.*;

public class Question1 {

    static void bucketSort(double[] arr) {
        int n = arr.length;

        List<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (double num : arr) {
            int index = (int) (num * n);
            buckets[index].add(num);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (double num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        bucketSort(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}