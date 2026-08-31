/* Problem: Detect cycle in directed graph using DFS and recursion stack.

Output:
- YES if cycle exists */

import java.util.*;

public class Question1 {

    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {

            // If neighbor is not visited, continue DFS
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
            }
            // Neighbor is already in current DFS path -> cycle
            else if (pathVisited[neighbor]) {
                return true;
            }
        }

        // Remove node from current recursion path
        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // Directed edge u -> v
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        boolean cycle = false;

        // Check all components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println(cycle ? "YES" : "NO");

        sc.close();
    }
}