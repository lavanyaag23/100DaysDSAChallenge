/* Problem Statement
Find shortest distances from source vertex in a weighted graph with non-negative weights.

Input Format
n m
u v w
source

Output Format
Distances to all vertices.

Sample Input
5 6
1 2 2
1 3 4
2 3 1
2 4 7
3 5 3
4 5 1
1

Sample Output
0 2 3 9 6

Explanation
Shortest distances computed via priority queue. */

import java.util.*;

public class Question1 {

    static void dijkstra(int n, ArrayList<ArrayList<int[]>> graph,
                         int source, int[] dist) {

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        dist[source] = 0;
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int node = current[0];
            int distance = current[1];

            if (distance > dist[node]) {
                continue;
            }

            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int weight = edge[1];

                if (distance + weight < dist[next]) {
                    dist[next] = distance + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
    }

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

        int source = sc.nextInt();

        int[] dist = new int[n + 1];

        dijkstra(n, graph, source, dist);

        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i] + " ");
        }

        sc.close();
    }
}