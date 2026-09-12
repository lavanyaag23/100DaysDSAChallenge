/*Problem Statement
Given weighted undirected graph, compute total weight of Minimum Spanning Tree using Prim’s algorithm.

Input Format
n m
u v w
...

Output Format
Total weight of MST.

Sample Input
4 5
1 2 3
1 3 5
2 3 1
2 4 4
3 4 2

Sample Output
6

Explanation
One possible MST edges: (2-3), (3-4), (1-2) */

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.offer(new int[]{1, 0});

        int totalWeight = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            int[] current = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalWeight += weight;
            count++;

            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0];
                int edgeWeight = edge[1];

                if (!visited[neighbor]) {
                    pq.offer(new int[]{neighbor, edgeWeight});
                }
            }
        }

        System.out.println(totalWeight);

        sc.close();
    }
}