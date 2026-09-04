/* Problem: Compute shortest path from source and detect negative weight cycles using Bellman-Ford.

Input:
- n vertices
- m edges (u,v,w)

Output:
- Shortest distances OR NEGATIVE CYCLE */

import java.util.*;

public class Question1 {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges.add(new Edge(u, v, w));
        }

        int source = sc.nextInt();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i <= n - 1; i++) {

            boolean updated = false;

            for (Edge edge : edges) {

                if (dist[edge.u] != Integer.MAX_VALUE &&
                    dist[edge.u] + edge.w < dist[edge.v]) {

                    dist[edge.v] = dist[edge.u] + edge.w;
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }

        boolean negativeCycle = false;

        for (Edge edge : edges) {

            if (dist[edge.u] != Integer.MAX_VALUE &&
                dist[edge.u] + edge.w < dist[edge.v]) {

                negativeCycle = true;
                break;
            }
        }

        if (negativeCycle) {
            System.out.println("NEGATIVE CYCLE");
        } else {
            System.out.println("Shortest distances:");

            for (int i = 0; i < n; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println(i + " : INF");
                } else {
                    System.out.println(i + " : " + dist[i]);
                }
            }
        }

        sc.close();
    }
}