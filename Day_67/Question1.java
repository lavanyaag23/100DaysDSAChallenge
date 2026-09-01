/* Problem: Print topological ordering of a Directed Acyclic Graph (DAG) using DFS. */

import java.util.*;

public class Question1 {

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // Add after visiting all neighbors
        stack.push(node);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Handle all components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Print topological order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        sc.close();
    }
}