// Platform: GeeksforGeeks
// Problem: Find Intersection Point of Two Linked Lists
// Difficulty: Easy

import java.util.*;

public class Question2 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

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

    static int findIntersection(Node head1, Node head2) {
        Node temp1 = head1;

        while (temp1 != null) {
            Node temp2 = head2;

            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    return temp1.data;
                }

                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head1 = createList(sc, n);

        int m = sc.nextInt();
        Node head2 = createList(sc, m);

        int result = findIntersection(head1, head2);

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("No Intersection");
        }

        sc.close();
    }
}