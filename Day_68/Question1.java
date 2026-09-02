/* Problem: Implement topological sorting using in-degree array and queue (Kahnâ€™s Algorithm). */

import java.util.*;

public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add vertices with in-degree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        System.out.print("Topological Order: ");

        int count = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            count++;

            for (int v : graph.get(u)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // If all vertices are processed, topological ordering exists
        if (count != n) {
            System.out.println("\nNo Topological Ordering (Cycle exists)");
        }

        sc.close();
    }
}