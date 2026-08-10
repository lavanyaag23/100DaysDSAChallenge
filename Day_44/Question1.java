/* Problem Statement:
Perform inorder, preorder, and postorder traversals of a given binary tree.

Input Format:
- First line contains integer N
- Second line contains level-order traversal (-1 represents NULL)

Output Format:
- Print inorder, preorder, and postorder traversals

Example:
Input:
7
1 2 3 4 5 6 7

Output:
4 2 5 1 6 3 7
1 2 4 5 3 6 7
4 5 2 6 7 3 1 */

import java.util.*;

public class Question1 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build tree from level-order traversal
    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Inorder: Left -> Root -> Right
    static void inorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.data);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.data);
    }

    static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(list.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        List<Integer> inorderResult = new ArrayList<>();
        List<Integer> preorderResult = new ArrayList<>();
        List<Integer> postorderResult = new ArrayList<>();

        inorder(root, inorderResult);
        preorder(root, preorderResult);
        postorder(root, postorderResult);

        // Print all outputs together
        printList(inorderResult);
        printList(preorderResult);
        printList(postorderResult);

        sc.close();
    }
}