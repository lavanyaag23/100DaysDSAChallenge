/* Problem Statement:
Implement a Min Heap using an array where the smallest element is always at the root.

Supported Operations:
- insert x
- extractMin
- peek

Input Format:
- First line contains integer N
- Next N lines contain heap operations

Output Format:
- Print results of extractMin and peek
- Print -1 if operation cannot be performed

Example:
Input:
6
insert 40
insert 10
insert 30
peek
extractMin
peek

Output:
10
10
30 */

import java.util.*;

public class Question1 {

    static class MinHeap {
        int[] heap;
        int size;

        MinHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        void insert(int value) {
            heap[size] = value;
            int index = size;
            size++;

            while (index > 0) {
                int parent = (index - 1) / 2;

                if (heap[index] < heap[parent]) {
                    swap(index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        int extractMin() {
            if (size == 0)
                return -1;

            int min = heap[0];

            heap[0] = heap[size - 1];
            size--;

            heapifyDown(0);

            return min;
        }

        int peek() {
            if (size == 0)
                return -1;

            return heap[0];
        }

        void heapifyDown(int index) {

            while (true) {
                int smallest = index;
                int left = 2 * index + 1;
                int right = 2 * index + 2;

                if (left < size && heap[left] < heap[smallest])
                    smallest = left;

                if (right < size && heap[right] < heap[smallest])
                    smallest = right;

                if (smallest != index) {
                    swap(index, smallest);
                    index = smallest;
                } else {
                    break;
                }
            }
        }

        void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        MinHeap minHeap = new MinHeap(n);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String operation = sc.next();

            if (operation.equals("insert")) {
                int value = sc.nextInt();
                minHeap.insert(value);
            }

            else if (operation.equals("extractMin")) {
                output.append(minHeap.extractMin()).append("\n");
            }

            else if (operation.equals("peek")) {
                output.append(minHeap.peek()).append("\n");
            }
        }

        System.out.print(output);

        sc.close();
    }
}