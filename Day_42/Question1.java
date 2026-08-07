/*Problem Statement:
Given a queue of integers, reverse the queue using a stack.

Input Format:
- First line contains integer N
- Second line contains N space-separated integers

Output Format:
- Print the reversed queue

Example:
Input:
5
10 20 30 40 50

Output:
50 40 30 20 10 */

import java.util.*;

public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        // Input queue elements
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        Stack<Integer> stack = new Stack<>();

        // Move queue elements to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Move stack elements back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Print reversed queue
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }

        sc.close();
    }
}
