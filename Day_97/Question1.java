/* Problem: Given meeting intervals, find minimum number of rooms required.
Sort by start time and use min-heap on end times. */

import java.util.*;

public class Question1 {

    static int minRooms(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            if (!pq.isEmpty() && pq.peek() <= meeting[0]) {
                pq.poll();
            }

            pq.offer(meeting[1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        System.out.println(minRooms(meetings));

        sc.close();
    }
}