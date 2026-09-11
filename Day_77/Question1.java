/*Problem Statement
Using BFS or DFS, check if the entire graph is connected.

Input Format
n m
edges

Output Format
CONNECTED
NOT CONNECTED

Sample Input
4 2
1 2
3 4

Sample Output
NOT CONNECTED */

import java.util.*;

public class Question1 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];

        dfs(1);

        boolean connected = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                connected = false;
                break;
            }
        }

        if (connected) {
            System.out.println("CONNECTED");
        } else {
            System.out.println("NOT CONNECTED");
        }

        sc.close();
    }
}