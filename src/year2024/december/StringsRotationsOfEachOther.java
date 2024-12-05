package year2024.december;

public class StringsRotationsOfEachOther {
    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "cdab";
        System.out.println("Is string rotations of each other: " + areRotationsKMP(s1, s2));
    }

    public static boolean areRotationsKMP(String s1, String s2) {

        String concatenetedString = s1 + s1;
        return search(s2, concatenetedString);
    }

    private static boolean search(String pat, String txt) {

        int n = txt.length();
        int m = pat.length();
        if (m > n) {
            return false;
        }
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
                return true;

            }
        }
        return false;
    }

    public static boolean areRotations(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        String concatenatedS1 = s1 + s1;
        return concatenatedS1.contains(s2);
    }
}
/*
Solution1: Naive Approach
The problem can be solved efficiently by checking if
s2 is a substring of s1+s1. The reasoning is that any rotation of
s1 can be found in the concatenated string s1+s1.

The time complexity of Java's String.contains() method depends on the implementation of the indexOf()
method, which it uses internally. The complexity is generally O(n×m) in the worst case, where:
n: Length of the string being searched in (the concatenated string).
m: Length of the substring being searched for.
This happens because indexOf() uses a simple sliding window approach (brute force) if no optimized
algorithms like Knuth-Morris-Pratt (KMP) are employed.

Solution2: Optimal Approach
Optimized Solution
To avoid O(n×m), use a more efficient substring search algorithm like Knuth-Morris-Pratt (KMP) or
Rabin-Karp. These algorithms reduce the complexity of the substring search to O(n+m).
Explanation of KMP:
Preprocessing: The LPS (Longest Prefix Suffix) array ensures that we skip unnecessary comparisons
during the substring search. Constructing the LPS array takes O(m).
Search: The search phase matches the pattern against the text efficiently in O(n).
Time Complexity:
Constructing the concatenated string: O(n).
KMP search: O(n+m), where n=2×s1.length(), so total complexity is O(n).
Space Complexity: O(m) for the LPS array.
O(n) for the concatenated string.
This approach ensures that even for large strings, the solution runs efficiently without
exceeding the time limits.
 */