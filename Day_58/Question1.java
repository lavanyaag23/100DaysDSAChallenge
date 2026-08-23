/* Problem Statement:
Construct a binary tree from given preorder and inorder traversal arrays.

Input Format:
- First line contains integer N
- Second line contains preorder traversal
- Third line contains inorder traversal

Output Format:
- Print postorder traversal of constructed tree

Example:
Input:
5
1 2 4 5 3
4 2 5 1 3

Output:
4 5 2 3 1

Explanation:
Preorder identifies root, inorder splits left and right subtrees. */

import java.util.*;

public class Question1 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int preorderIndex = 0;
    static HashMap<Integer, Integer> inorderMap = new HashMap<>();

    static Node buildTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = preorder[preorderIndex++];
        Node root = new Node(value);

        int mid = inorderMap.get(value);

        root.left = buildTree(preorder, left, mid - 1);
        root.right = buildTree(preorder, mid + 1, right);

        return root;
    }

    static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] preorder = new int[n];
        int[] inorder = new int[n];

        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
            inorderMap.put(inorder[i], i);
        }

        Node root = buildTree(preorder, 0, n - 1);

        postorder(root);

        sc.close();
    }
}