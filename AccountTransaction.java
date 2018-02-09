/**
Problem:
Given my bank account transactions - debits and credits - as a sequence of integers, at
what points do my behaviors show the same sub-sums of all transactions before or
after. Basically can you find the equilibria points of my bank account?
Input:
You'll be given input over two lines. The first line tells you how many distinct values to
read in the following line. The next line is sequence of integers showing credits and
debits.
Example:
8
0 -3 5 -4 -2 3 1 0
Output:
Your program should emit the positions (0-indexed) where the sum of the
sub-sequences before and after the position are the same. For the above:
0 3 7
Meaning the zeroth, third and seventh positions have the same sum before and after.
Challenge Input:
11
3 -2 2 0 3 4 -6 3 5 -4 8
11
9 0 -5 -4 1 4 -4 -9 0 -7 -1
11
9 -7 6 -8 3 -9 -5 3 -6 -8 5
Output:
5
8
6
Hint:
See if you can find the O(n) solution and not the O(n2) solution.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Gridle {
    static List < Integer > transaction(int size, int[] input) {
        int[] right = new int[size];
        List < Integer > output = new ArrayList < Integer > ();
        int prev = 0;
        right[size - 1] = 0;
        for (int i = size - 2; i >= 0; i--) {
            prev += input[i + 1];
            right[i] = prev;
        }
        prev = 0;
        if (right[0] == 0) {
            output.add(0);
        }
        for (int i = 1; i < size; i++) {
            prev += input[i - 1];
            if (right[i] == prev) {
                output.add(i);
            }
        }
        return output;
    }
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++)
            input[i] = sc.nextInt();
        for (int pos: transaction(n, input))
            System.out.print(pos + " ");
    }
}
