package year2024.december;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {

        String s1 = "sadbutsad";
        String s2 = "sad";
        System.out.println("Result: " + strStrKMP(s1, s2));
    }

    static int strStrKMP(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();
        int[] lps = new int[m];
        int prevLPS = 0, i = 1;
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(prevLPS)) {
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
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }

    static int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) {
            return -1;
        }
        int i, j;
        for (i = 0; i < haystack.length(); i++) {
            int k = i;
            for (j = 0; j < needle.length(); j++) {
                if (k >= haystack.length() || haystack.charAt(k) != needle.charAt(j)) {
                    break;
                }
                k++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
/*
Solution 1: Brute-Force Solution (Easy)
This is brute force solution here for every element of haystack I am checking if it is
start of the substring equal to the needle.
Time Complexity: O(n*m)
Space complexity: O(1)

Solution 2: Knuth-Morris-Pratt(KMP) Algorithm (Very-very Hard(Complex) )
Time Complexity O(n+m)
Space complexity O(m)

Explanation of KMP:
Preprocessing: The LPS (Longest Prefix Suffix) array ensures that we skip unnecessary comparisons
during the substring search. Constructing the LPS array takes
O(m).

Search: The search phase matches the pattern against the text efficiently in
O(n).

This approach ensures that even for large strings, the solution runs efficiently without exceeding
the time limits.
 */