/* Problem: Level Order Traversal

Implement the solution for this problem.

Input:
- Input specifications

Output:
- Output specifications */

import java.util.*;

public class Question1 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node buildTree(int[] a) {
        if (a.length == 0 || a[0] == -1) return null;

        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (i < a.length) {
            Node cur = q.poll();

            if (a[i] != -1) {
                cur.left = new Node(a[i]);
                q.add(cur.left);
            }
            i++;

            if (i < a.length && a[i] != -1) {
                cur.right = new Node(a[i]);
                q.add(cur.right);
            }
            i++;
        }

        return root;
    }

    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Node root = buildTree(a);
        levelOrder(root);
    }
}