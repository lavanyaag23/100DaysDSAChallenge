/* Problem Statement:
Construct a binary tree from given inorder and postorder traversal arrays.

Input Format:
- First line contains integer N
- Second line contains inorder traversal
- Third line contains postorder traversal

Output Format:
- Print preorder traversal of constructed tree

Example:
Input:
5
4 2 5 1 3
4 5 2 3 1

Output:
1 2 4 5 3

Explanation:
Postorder gives root at end, inorder divides left and right subtrees. */

import java.util.*;

public class Question1 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int postorderIndex;
    static HashMap<Integer, Integer> inorderMap = new HashMap<>();

    static Node buildTree(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = postorder[postorderIndex--];
        Node root = new Node(value);

        int mid = inorderMap.get(value);

        // Build right subtree first
        root.right = buildTree(postorder, mid + 1, right);
        root.left = buildTree(postorder, left, mid - 1);

        return root;
    }

    static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] inorder = new int[n];
        int[] postorder = new int[n];

        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
            inorderMap.put(inorder[i], i);
        }

        for (int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt();
        }

        postorderIndex = n - 1;

        Node root = buildTree(postorder, 0, n - 1);

        preorder(root);

        sc.close();
    }
}