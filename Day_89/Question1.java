/* Problem Statement
Given an array of integers where each element represents the number of pages in a book, and m students, allocate books such that each student gets at least one book and the maximum number of pages assigned to a student is minimized.

Books must be allocated in contiguous order.

Input Format
n m
n space-separated integers representing pages in books

Output Format
Print the minimum possible value of the maximum pages assigned to any student.

Sample Input
4 2
12 34 67 90

Sample Output
113

Explanation
One optimal allocation is:
Student 1: 12 + 34 + 67 = 113
Student 2: 90
Maximum pages = 113 (minimum possible). */

import java.util.*;

public class Question1 {

    static boolean canAllocate(int[] pages, int students, int maxPages) {
        int count = 1;
        int currentPages = 0;

        for (int page : pages) {
            if (currentPages + page > maxPages) {
                count++;
                currentPages = page;

                if (count > students) {
                    return false;
                }
            } else {
                currentPages += page;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] pages = new int[n];
        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
            low = Math.max(low, pages[i]);
            high += pages[i];
        }

        if (m > n) {
            System.out.println(-1);
            return;
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(pages, m, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}