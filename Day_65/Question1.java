/* Problem: Using DFS and parent tracking, detect if undirected graph has a cycle.

Output:
- YES or NO */

import java.util.*;

public class Question1 {

    static boolean dfs(int node, int parent,
                       ArrayList<ArrayList<Integer>> graph,
                       boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, node, graph, visited)) {
                    return true;
                }
            }
            else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    static boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] edges = new int[E][2];

        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.println(isCycle(V, edges) ? "YES" : "NO");

        sc.close();
    }
}