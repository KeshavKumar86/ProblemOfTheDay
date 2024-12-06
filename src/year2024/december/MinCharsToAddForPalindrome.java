package year2024.december;

public class MinCharsToAddForPalindrome {
    public static void main(String[] args) {

        String s = "aaceca";
        System.out.println("Result: " + minChar(s));
    }

    public static int minCharBruteForce(String s) {

        int addCount = 0;
        while (!isPalindrome(s)) {
            s = s.substring(0, s.length() - 1);
            addCount++;

        }
        return addCount;
    }

    private static boolean isPalindrome(String s) {

        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static int minChar(String s) {

        String reverse = new StringBuilder(s).reverse().toString();
        String concatenatedString = s + "$" + reverse;
        int n = concatenatedString.length();
        int[] lps = new int[n];
        int prevLPS = 0, i = 1;
        while (i < n) {
            if (concatenatedString.charAt(i) == concatenatedString.charAt(prevLPS)) {
                prevLPS++;
                lps[i] = prevLPS;
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
        return s.length() - lps[n - 1];
    }
}
/*
Intuition to solve the problem: check the longest palindrome substring starting from start of
the string and then answer will be the = totalLength - longest palindrome substring
Example: aacecaaaa here we know that longest palindrome substring from start is aacecaa than means
if we put the reverse of remaining characters from last to the start than whole string will become
palindrome.

Solution1: Brute force Approach
1. Brute Force Approach
Check if the string is a palindrome.
If not, remove one character at a time from the end of the string until the remaining prefix is a
palindrome.
The number of removed characters gives the count of characters to add at the front.

Solution2: Optimal Solution
The observation is that the longest palindromic prefix becomes longest palindromic suffix of
its reverse.
For string = aacecaaaa
Reverse string = aaaacecaa
longest palindromic prefix = aacecaa
Now to find this prefix the idea is to use lps array of KMP algorithm,
Complexity:
Time complexity: O(n), where n is the length of the combined string.
Space complexity: O(n) for the LPS array and for concatenatedString.

2. Using Two Pointers
This approach tries to find the longest palindrome suffix directly without creating additional data structures.

Steps:
Use two pointers (left and right).
Move the right pointer until a palindrome suffix is found.
The number of unmatched characters on the left gives the minimum characters to add.
Java Implementation:
public class PalindromeMinAdd {
    public static int minCharsToAdd(String s) {
        int left = 0, right = s.length() - 1;
        int unmatched = 0;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                unmatched++;
                left = 0; // Reset left pointer
                right = s.length() - 1 - unmatched; // Shorten string from the right
            }
        }
        return unmatched;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println("Minimum characters to add: " + minCharsToAdd(s)); // Output: 2
    }
}
Complexity:
Time complexity: O(n) in most cases, as we typically move through the string once.
Space complexity: O(1).
 */
