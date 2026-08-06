/* Problem Statement:
Implement a Queue using a linked list supporting enqueue and dequeue operations.

Input Format:
- First line contains integer N
- Next N lines contain queue operations

Output Format:
- Print dequeued elements
- Print -1 if dequeue is attempted on an empty queue */

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Question1 {
    static Node front = null, rear = null;

    // Enqueue
    static void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue
    static int dequeue() {
        if (front == null) {
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            if (operation.equals("enqueue")) {
                int value = sc.nextInt();
                enqueue(value);
            } else if (operation.equals("dequeue")) {
                output.add(dequeue());
            }
        }

        for (int value : output) {
            System.out.println(value);
        }

        sc.close();
    }
}