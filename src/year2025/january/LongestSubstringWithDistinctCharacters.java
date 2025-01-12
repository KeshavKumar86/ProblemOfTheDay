package year2025.january;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {

        // s = "dvdf"
        String s = "abcdecfghi";
        System.out.println("Result: " + longestUniqueSubstring(s));
    }

    private static int longestUniqueSubstr(String s) {

        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                while (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(s.charAt(j));
            j++;
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }

    private static int longestUniqueSubstring(String s) {

        int max = 0;
        Set<Character> set;
        int i, j;
        for (i = 0; i < s.length(); i++) {
            set = new HashSet<>();
            for (j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
/*
Solution1: Brute Force Solution
Iterate every substring and find the maximum length of substring having distinct characters.
To Iterate every substring we require 2 loops.
Time Complexity: O(n^2)
Space Complexity: O(n) if it contains n distinct characters
Solution2: Optimal Solution
Intuition: Because question is asking for longest substring, so it gives us hint that we have to use
variable size sliding window.To check when we have to move the window we have to check
if that window already contains upcoming character in the iteration in constant time, to check that in
constant time we have to use the set.
Both i and j traverse the strings linearly, and each character is processed at most twice
(once when added to the set and possibly once when removed). Hence, the total number of operations
is proportional to 2n.
Time Complexity: O(n)
The space complexity is O(k), where
k is the size of the character set. For example:
If the input string s contains only lowercase English letters,
k≤26.
If s contains all possible Unicode characters,
k can be large.
Space complexity:O(n) ( for safer side)
 */