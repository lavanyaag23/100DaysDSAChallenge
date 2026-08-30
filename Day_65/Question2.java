/* GFG Problem — Undirected Graph Cycle

Problem:
Given an undirected graph with V vertices and E edges, determine whether the graph contains a cycle. The graph may have multiple disconnected components.

Input:

V — number of vertices
E — number of edges
edges[][] — pairs [u, v] representing edges

Output:
Return true if the graph contains a cycle; otherwise, return false. */

import java.util.*;

public class Question2 {

    static boolean bfs(int start, ArrayList<ArrayList<Integer>> graph,
                       boolean[] visited) {

        Queue<int[]> queue = new LinkedList<>();

        // {node, parent}
        queue.offer(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int node = current[0];
            int parent = current[1];

            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, node});
                }
                else if (neighbor != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Handle disconnected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, graph, visited)) {
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

        System.out.println(isCycle(V, edges));

        sc.close();
    }
}