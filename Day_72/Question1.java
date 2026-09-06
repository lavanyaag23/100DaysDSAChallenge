/* Problem Statement
Given a string s consisting of lowercase letters, find the first repeated character in the string. A character is considered repeated if it appears more than once, and among all such characters, the one whose second occurrence has the smallest index should be returned.

Input Format
A single string s.

Output Format
Print the first repeated character. If no character is repeated, print -1.

Sample Input
geeksforgeeks

Sample Output
e */

import java.util.*;

public class Question1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        boolean[] seen = new boolean[26];
        char answer = 0;

        for (char ch : s.toCharArray()) {

            if (seen[ch - 'a']) {
                answer = ch;
                break;
            }

            seen[ch - 'a'] = true;
        }

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

        sc.close();
    }
}
