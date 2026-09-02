import java.util.*;

public class Question2 {

    static String findOrder(String[] words) {

        int K = 26;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[K];
        boolean[] present = new boolean[K];

        // Mark characters present in the dictionary
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        // Build graph using adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int len = Math.min(word1.length(), word2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {

                if (word1.charAt(j) != word2.charAt(j)) {

                    int u = word1.charAt(j) - 'a';
                    int v = word2.charAt(j) - 'a';

                    // Avoid duplicate edges
                    if (!graph.get(u).contains(v)) {
                        graph.get(u).add(v);
                        indegree[v]++;
                    }

                    found = true;
                    break;
                }
            }

            // Invalid case: longer word comes before its prefix
            if (!found && word1.length() > word2.length()) {
                return "";
            }
        }

        // Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            if (present[i] && indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            int u = queue.poll();

            result.append((char) ('a' + u));

            for (int v : graph.get(u)) {

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // Check for cycle
        int totalCharacters = 0;

        for (boolean x : present) {
            if (x) {
                totalCharacters++;
            }
        }

        if (result.length() != totalCharacters) {
            return "";
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        System.out.println("Enter the words:");

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        String answer = findOrder(words);

        if (answer.isEmpty()) {
            System.out.println("No valid ordering exists.");
        } else {
            System.out.println("Alien Dictionary Order: " + answer);
        }

        sc.close();
    }
}