/* Problem: Circular Queue Using Array - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n (number of elements to enqueue)
- Second line: n space-separated integers
- Third line: integer m (number of dequeue operations)

Output:
- Print queue elements from front to rear after operations, space-separated

Example:
Input:
5
10 20 30 40 50
2

Output:
30 40 50 10 20

Explanation:
Use array and front/rear pointers. Rear wraps around to start after reaching array end. Dequeue removes elements from front.
 Display remaining elements in correct order. */

import java.util.Scanner;

public class Question1 {

    static class CircularQueue {
        int[] arr;
        int front, rear, size, capacity;

        CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        void enqueue(int value) {
            if (size == capacity) {
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
        }

        void dequeue() {
            if (size == 0) {
                return;
            }
            front = (front + 1) % capacity;
            size--;
        }

        void display() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return;
            }

            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        CircularQueue queue = new CircularQueue(n);

        for (int i = 0; i < n; i++) {
            queue.enqueue(sc.nextInt());
        }

        int m = sc.nextInt();

        // Rotate the queue by performing dequeue followed by enqueue
        for (int i = 0; i < m; i++) {
            int value = queue.arr[queue.front];
            queue.dequeue();
            queue.enqueue(value);
        }

        queue.display();

        sc.close();
    }
}