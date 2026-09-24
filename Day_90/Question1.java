/* Problem Statement
Given n boards of different lengths and k painters, each painter paints contiguous boards. Painting a unit length of board takes one unit of time.

Determine the minimum time required to paint all boards.

Input Format
n k
n space-separated integers representing board lengths

Output Format
Print the minimum time required to paint all boards.

Sample Input
4 2
10 20 30 40

Sample Output
60

Explanation
One painter paints boards of length 10, 20, and 30 (total 60), 
while the other paints board of length 40. */

import java.util.*;

public class Question1 {

    static boolean canPaint(int[] boards, int painters, long maxTime) {
        int count = 1;
        long currentTime = 0;

        for (int board : boards) {
            if (currentTime + board > maxTime) {
                count++;
                currentTime = board;

                if (count > painters) {
                    return false;
                }
            } else {
                currentTime += board;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] boards = new int[n];
        long low = 0;
        long high = 0;

        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();
            low = Math.max(low, boards[i]);
            high += boards[i];
        }

        if (k > n) {
            System.out.println(-1);
            return;
        }

        long answer = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canPaint(boards, k, mid)) {
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
