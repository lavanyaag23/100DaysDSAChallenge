/* Problem Statement
Implement a hash table using quadratic probing with formula:

h(k, i) = (h(k) + i*i) % m

Input Format
Same as previous.

Output Format
Result of SEARCH operations.

Sample Input
7
4
INSERT 49
INSERT 56
SEARCH 49
SEARCH 15

Sample Output
FOUND
NOT FOUND

Explanation
Collisions resolved using i² jumps. */

import java.util.*;

public class Question1 {

    static int[] table;
    static int m;

    static void insert(int key) {
        int h = key % m;

        for (int i = 0; i < m; i++) {
            int index = (h + i * i) % m;

            if (table[index] == -1) {
                table[index] = key;
                return;
            }
        }
    }

    static boolean search(int key) {
        int h = key % m;

        for (int i = 0; i < m; i++) {
            int index = (h + i * i) % m;

            if (table[index] == -1) {
                return false;
            }

            if (table[index] == key) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        int q = sc.nextInt();

        table = new int[m];
        Arrays.fill(table, -1);

        for (int i = 0; i < q; i++) {
            String operation = sc.next();

            if (operation.equals("INSERT")) {
                int key = sc.nextInt();
                insert(key);
            } else if (operation.equals("SEARCH")) {
                int key = sc.nextInt();

                if (search(key)) {
                    System.out.println("FOUND");
                } else {
                    System.out.println("NOT FOUND");
                }
            }
        }

        sc.close();
    }
}