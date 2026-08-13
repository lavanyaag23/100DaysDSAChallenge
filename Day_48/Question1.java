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
        if (a.length == 0 || a[0] == -1)
            return null;

        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (i < a.length) {
            Node curr = q.poll();

            if (i < a.length && a[i] != -1) {
                curr.left = new Node(a[i]);
                q.add(curr.left);
            }
            i++;

            if (i < a.length && a[i] != -1) {
                curr.right = new Node(a[i]);
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    static int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Node root = buildTree(a);

        System.out.println(countLeaves(root));
    }
}