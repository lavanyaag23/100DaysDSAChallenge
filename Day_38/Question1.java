/* Problem: Deque (Double-Ended Queue)

A Deque is a linear data structure that allows insertion and deletion of elements from both the front and the rear. It provides more flexibility than a standard queue or stack.

Common Operations:
1. push_front(value): Insert an element at the front of the deque.
2. push_back(value): Insert an element at the rear of the deque.
3. pop_front(): Remove an element from the front of the deque.
4. pop_back(): Remove an element from the rear of the deque.
5. front(): Return the front element of the deque.
6. back(): Return the rear element of the deque.
7. empty(): Check whether the deque is empty.
8. size(): Return the number of elements in the deque.

Additional Operations:
- clear(): Remove all elements from the deque.
- erase(): Remove one or more elements from the deque.
- swap(): Swap contents of two deques.
- emplace_front(): Insert an element at the front without copying.
- emplace_back(): Insert an element at the rear without copying.
- resize(): Change the size of the deque.
- assign(): Replace elements with new values.
- reverse(): Reverse the order of elements.
- sort(): Sort the elements in ascending order.

Time Complexity:
- push_front, push_back, pop_front, pop_back, front, back, empty, size: O(1)
- clear, erase, resize, assign, reverse: O(n)
- sort: O(n log n)

Input:
- Sequence of deque operations with values (if applicable)

Output:
- Results of operations such as front, back, size, or the final state of the deque after all operations */

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        int n = sc.nextInt(); // Number of operations

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            switch (operation) {
                case "push_front":
                    deque.addFirst(sc.nextInt());
                    break;

                case "push_back":
                    deque.addLast(sc.nextInt());
                    break;

                case "pop_front":
                    if (deque.isEmpty())
                        System.out.println("Deque is empty");
                    else
                        deque.removeFirst();
                    break;

                case "pop_back":
                    if (deque.isEmpty())
                        System.out.println("Deque is empty");
                    else
                        deque.removeLast();
                    break;

                case "front":
                    if (deque.isEmpty())
                        System.out.println("Deque is empty");
                    else
                        System.out.println(deque.peekFirst());
                    break;

                case "back":
                    if (deque.isEmpty())
                        System.out.println("Deque is empty");
                    else
                        System.out.println(deque.peekLast());
                    break;

                case "size":
                    System.out.println(deque.size());
                    break;

                case "empty":
                    System.out.println(deque.isEmpty());
                    break;

                case "clear":
                    deque.clear();
                    break;

                default:
                    System.out.println("Invalid Operation");
            }
        }

        System.out.print("Deque: ");
        for (int x : deque) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}