/* Problem: Implement push and pop operations on a stack and verify stack operations.

Input:
- First line: integer n
- Second line: n integers to push
- Third line: integer m (number of pops)

Output:
- Print remaining stack elements from top to bottom

Example:
Input:
5
10 20 30 40 50
2

Output:
30 20 10 */

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of elements
        int n = sc.nextInt();

        int[] stack = new int[n];
        int top = -1;

        // Push elements
        for (int i = 0; i < n; i++) {
            stack[++top] = sc.nextInt();
        }

        // Number of pop operations
        int m = sc.nextInt();

        // Pop m elements
        for (int i = 0; i < m; i++) {
            if (top >= 0) {
                top--;
            }
        }

        // Display remaining stack from top to bottom
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i]);

            if (i > 0) {
                System.out.print(" ");
            }
        }

        System.out.println();

        sc.close();
    }
}