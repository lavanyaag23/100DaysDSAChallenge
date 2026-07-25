/* Problem: Rotate Linked List Right by k Places - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n
- Second line: n space-separated integers
- Third line: integer k

Output:
- Print the linked list elements after rotation, space-separated

Example:
Input:
5
10 20 30 40 50
2

Output:
40 50 10 20 30

Explanation:
Connect last node to head forming circular list.
 Traverse to (n-k)th node, set next to NULL, update head to (n-k+1)th node. */

import java.util.*;

public class Question1 {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Rotate linked list right by k positions
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and last node
        int length = 1;
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Reduce unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        tail.next = head;

        // Find new tail
        int steps = length - k;
        Node newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Update head
        Node newHead = newTail.next;

        // Break the circular link
        newTail.next = null;

        return newHead;
    }

    // Print linked list
    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input n
        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        // Create linked list
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Input k
        int k = sc.nextInt();

        // Rotate list
        head = rotateRight(head, k);

        // Print result
        printList(head);

        sc.close();
    }
}