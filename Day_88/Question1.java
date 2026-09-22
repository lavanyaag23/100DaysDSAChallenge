/* Problem Statement
Given n stalls located at different positions along a straight line and k cows, place the cows in the stalls such that the minimum distance between any two cows is maximized.

This is an optimization problem where binary search on the answer is required.

Input Format
n k
n space-separated integers representing stall positions

Output Format
Print the maximum possible minimum distance between any two cows.

Sample Input
5 3
1 2 8 4 9

Sample Output
3

Explanation
Cows can be placed at positions 1, 4, and 8.
 The minimum distance between any two cows is 3, which is the maximum possible. */

 import java.util.*;

public class Question1 {

    static boolean canPlace(int[] stalls, int k, int distance) {
        int count = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];

                if (count >= k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] stalls = new int[n];

        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}