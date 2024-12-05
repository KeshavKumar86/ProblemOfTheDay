package year2024.december;

import java.util.ArrayList;

public class SearchPatternKMPAlgorithm {
    public static void main(String[] args) {

        String pat = "abcd";
        String txt = "abcdabcdabcdabcd";
        System.out.println("Result: " + searchKMP(pat, txt));
    }

    static ArrayList<Integer> searchKMP(String pat, String txt) {

        int n = txt.length();
        int m = pat.length();
        ArrayList<Integer> list = new ArrayList<>();
        if (m > n) {
            return list;
        }
        //construct Longest Prefix Suffix Array
        int[] lps = new int[m];
        int prevLPS = 0, i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else {
                if (prevLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLPS = lps[prevLPS - 1];
                }
            }
        }

        i = 0;
        int j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
                i++;

            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }

            }
            if (j == m) {
                list.add(i - m);
                j = lps[j - 1];

            }
        }
        return list;
    }

    static ArrayList<Integer> search(String pat, String txt) {

        ArrayList<Integer> list = new ArrayList<>();
        if (txt.length() < pat.length()) {
            return list;
        }
        for (int i = 0; i < txt.length(); i++) {
            if (i + pat.length() <= txt.length() && txt.substring(i, i + pat.length()).equals(pat)) {
                list.add(i);
            }
        }
        return list;
    }
}
/*
Solution 1: Brute-Force Solution (Easy)
This is brute force solution here for every element of txt I am checking if it is
start of the substring equal to the pat.
Time Complexity: O(n*m)
Space complexity: O(n) for storing result in array list.

Solution 2: Knuth-Morris-Pratt(KMP) Algorithm (Very-very Hard(Complex) )
Time Complexity O(n+m)
Space complexity
O(m) for Longest Prefix Suffix
O(n) for storing result in array list.
Overall Space Complexity: O(n+m) = O(n)

Explanation of KMP:
Preprocessing: The LPS (Longest Prefix Suffix) array ensures that we skip unnecessary comparisons
during the substring search. Constructing the LPS array takes
O(m).

Search: The search phase matches the pattern against the text efficiently in
O(n).

This approach ensures that even for large strings, the solution runs efficiently without exceeding
the time limits.
 */