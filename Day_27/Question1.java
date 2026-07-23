/* Problem: Find Intersection Point of Two Linked Lists - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n
- Second line: n space-separated integers (first list)
- Third line: integer m
- Fourth line: m space-separated integers (second list)

Output:
- Print value of intersection node or 'No Intersection'

Example:
Input:
5
10 20 30 40 50
4
15 25 30 40 50

Output:
30

Explanation:
Calculate lengths, advance pointer in longer list, traverse both simultaneously.
 First common node is intersection. */

// Platform: GeeksforGeeks
// Problem: Remove Loop in Linked List
// Difficulty: Medium

import java.util.Scanner;

public class Question1 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Remove loop from linked list
    static void removeLoop(Node head) {

        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        // Detect loop using Floyd's Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No loop
        if (slow != fast) {
            return;
        }

        // Find starting point of loop
        slow = head;

        // Special case: Loop starts at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Remove loop
        fast.next = null;
    }

    // Create linked list
    static Node createList(Scanner sc, int n) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {

            Node newNode = new Node(sc.nextInt());

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    // Create loop at given position
    static void createLoop(Node head, int pos) {

        if (pos == -1) {
            return;
        }

        Node loopNode = head;
        Node tail = head;

        for (int i = 0; i < pos; i++) {
            loopNode = loopNode.next;
        }

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = loopNode;
    }

    // Check whether loop exists
    static boolean hasLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input: number of nodes
        int n = sc.nextInt();

        // Input: node values
        Node head = createList(sc, n);

        // Input: position where loop starts
        int pos = sc.nextInt();

        // Create loop
        createLoop(head, pos);

        // Remove loop
        removeLoop(head);

        // Check if loop was successfully removed
        if (!hasLoop(head)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close();
    }
}