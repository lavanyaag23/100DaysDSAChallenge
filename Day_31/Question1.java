/* Problem: Implement a stack data structure using an array with the following operations: push, pop, and display.

Input:
- First line: integer n (number of operations)
- Next n lines: operation type and value (if applicable)
  - 1 value: push value
  - 2: pop
  - 3: display

Output:
- For display: print stack elements from top to bottom
- For pop: print popped element or 'Stack Underflow'

Example:
Input:
5
1 10
1 20
3
2
3

Output:
20 10
20
10 */

import java.util.Scanner;

public class Question1 {

    static class Stack {
        int[] arr;
        int top;
        int capacity;

        Stack(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            top = -1;
        }

        void push(int value) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }

            arr[++top] = value;
        }

        void pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return;
            }

            System.out.println(arr[top--]);
        }

        void display() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return;
            }

            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i]);

                if (i != 0) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of operations
        int n = sc.nextInt();

        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {

            // Read operation type
            int operation = sc.nextInt();

            if (operation == 1) {
                // Push operation
                int value = sc.nextInt();
                stack.push(value);

            } else if (operation == 2) {
                // Pop operation
                stack.pop();

            } else if (operation == 3) {
                // Display operation
                stack.display();
            }
        }

        sc.close();
    }
}