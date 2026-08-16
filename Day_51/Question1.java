/* Problem Statement:
Find the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree.

Input Format:
- First line contains integer N
- Second line contains N space-separated integers
- Third line contains two node values

Output Format:
- Print the LCA value

Example:
Input:
7
6 2 8 0 4 7 9
2 8

Output:
6 */

import java.util.*;

public class Question1 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    static Node findLCA(Node root, int p, int q) {
        while (root != null) {
            if (p < root.data && q < root.data) {
                root = root.left;
            } else if (p > root.data && q > root.data) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        int p = sc.nextInt();
        int q = sc.nextInt();

        Node lca = findLCA(root, p, q);

        if (lca != null)
            System.out.println(lca.data);
        else
            System.out.println(-1);
    }
}