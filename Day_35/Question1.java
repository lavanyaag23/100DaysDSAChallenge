/* Problem: Queue Using Array - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n (number of elements)
- Second line: n space-separated integers

Output:
- Print queue elements from front to rear, space-separated

Example:
Input:
5
10 20 30 40 50

Output:
10 20 30 40 50

Explanation:
Use array and front/rear pointers. Enqueue inserts at rear, dequeue removes from front. Display from front to rear. */

import java.util.Scanner;

public class Question1 {

    static class Queue {
        int[] arr;
        int front, rear, size;

        Queue(int capacity) {
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        void enqueue(int value) {
            if (size == arr.length) {
                System.out.println("Queue Overflow");
                return;
            }
            rear++;
            arr[rear] = value;
            size++;
        }

        int dequeue() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int value = arr[front];
            front++;
            size--;
            return value;
        }

        void display() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return;
            }

            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue queue = new Queue(n);

        for (int i = 0; i < n; i++) {
            queue.enqueue(sc.nextInt());
        }

        queue.display();

        sc.close();
    }
}