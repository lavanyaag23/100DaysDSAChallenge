/* Problem: BST Search

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

    static Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    static Node search(Node root, int value) {
        if (root == null || root.data == value)
            return root;

        if (value < root.data)
            return search(root.left, value);

        return search(root.right, value);
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        int value = sc.nextInt();

        Node result = search(root, value);

        if (result == null) {
            System.out.println("-1");
        } else {
            inorder(result);
            System.out.println();
        }
    }
}