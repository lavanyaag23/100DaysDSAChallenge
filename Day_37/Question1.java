/* Problem Statement:
Implement a Priority Queue using an array. An element with smaller value has higher priority.

Supported Operations:
- insert x
- delete
- peek

Input Format:
- First line contains integer N
- Next N lines contain operations

Output Format:
- Print the deleted or peeked element
- Print -1 if the queue is empty

Example:
Input:
5
insert 30
insert 10
insert 20
delete
peek

Output:
10
20 */

import java.util.Scanner;

public class Question1 {

    static class PriorityQueueArray {
        int[] arr;
        int size;

        PriorityQueueArray(int capacity) {
            arr = new int[capacity];
            size = 0;
        }

        // Insert element
        void insert(int value) {
            arr[size++] = value;
        }

        // Delete highest priority (smallest element)
        int delete() {
            if (size == 0)
                return -1;

            int minIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }

            int deleted = arr[minIndex];

            for (int i = minIndex; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }

            size--;
            return deleted;
        }

        // Peek highest priority
        int peek() {
            if (size == 0)
                return -1;

            int min = arr[0];
            for (int i = 1; i < size; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }

            return min;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueueArray pq = new PriorityQueueArray(n);

        for (int i = 0; i < n; i++) {

            String op = sc.next();

            if (op.equals("insert")) {
                int value = sc.nextInt();
                pq.insert(value);
            } else if (op.equals("delete")) {
                System.out.println(pq.delete());
            } else if (op.equals("peek")) {
                System.out.println(pq.peek());
            }
        }

        sc.close();
    }
}