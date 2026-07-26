/* Problem: Polynomial Using Linked List - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n (number of terms)
- Next n lines: two integers (coefficient and exponent)

Output:
- Print polynomial in standard form, e.g., 10x^4 + 20x^3 + 30x^2 + 40x + 50

Example:
Input:
5
10 4
20 3
30 2
40 1
50 0

Output:
10x^4 + 20x^3 + 30x^2 + 40x + 50

Explanation:
Each node stores coefficient and exponent. Traverse nodes to print polynomial in decreasing exponent order. */

import java.util.Scanner;

public class Question1 {

    static class Node {
        int coefficient;
        int exponent;
        Node next;

        Node(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }

    static Node head = null;

    // Insert a term at the end
    static void insert(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Display polynomial
    static void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.coefficient);

            if (temp.exponent > 1) {
                System.out.print("x^" + temp.exponent);
            } else if (temp.exponent == 1) {
                System.out.print("x");
            }

            if (temp.next != null) {
                System.out.print(" + ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int coefficient = sc.nextInt();
            int exponent = sc.nextInt();

            insert(coefficient, exponent);
        }

        display();

        sc.close();
    }
}