package year2025.january;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {

        // s = "geeksforgeeks"
        String s = "dvdf";
        System.out.println("Result: " + longestUniqueSubstr(s));
    }

    private static int longestUniqueSubstr(String s) {

        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                maxLength = Math.max(maxLength, j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;

            }
            set.add(s.charAt(j));
            j++;
        }
        maxLength = Math.max(maxLength, j - i);
        return maxLength;
    }
}
/*
Solution2: Optimal Solution
Intuition: Because question is asking for longest substring, so it gives us hint that we have to use
variable size sliding window.To check when we have to move the window we have to check
if that window already contains upcoming character in the iteration in constant time, to check that in
constant time we have to use the set.
Both i and j traverse the string s linearly, and each character is processed at most twice
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