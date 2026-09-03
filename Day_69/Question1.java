/* Problem: Given weighted graph with non-negative edges, compute shortest path from source using priority queue. */

import java.util.*;

public class Question1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Input edges: u v weight
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new int[]{v, w});
        }

        int source = sc.nextInt();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        // {distance, node}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, source});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentDist = current[0];
            int u = current[1];

            // Ignore outdated entry
            if (currentDist > dist[u]) {
                continue;
            }

            for (int[] edge : graph.get(u)) {

                int v = edge[0];
                int weight = edge[1];

                int newDist = currentDist + weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{newDist, v});
                }
            }
        }

        System.out.println("Shortest distances from source:");

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : INF");
            } else {
                System.out.println(i + " : " + dist[i]);
            }
        }

        sc.close();
    }
}