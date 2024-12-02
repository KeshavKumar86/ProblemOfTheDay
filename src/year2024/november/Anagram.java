package year2024.november;

public class Anagram {
    public static void main(String[] args) {

        String s1 = "g", s2 = "g";
        System.out.println("Result: " + areAnagrams(s1, s2));
    }

    public static boolean areAnagrams(String s1, String s2) {

        //This will take constant space
        int[] charCount = new int[26];
        if (s1.length() != s2.length())
            return false;
        //This will take linear O(n) time
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }
        //This will take constant O(1) time
        for (int i : charCount) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
/*
Brute Force: A brute force solution for checking if two strings are anagrams involves comparing all
possible arrangements of one string with the other string. This approach, while not efficient,
guarantees correctness.

Here’s how a brute force solution might look:

Generate All Permutations:
Generate all permutations of one string (e.g., s1) and check if any of them equals the other string
(s2).
Time Complexity:
Generating permutations of a string of length 𝑛 has a factorial time complexity:
O(n!).
Space Complexity:

Storing all permutations in a Set takes
O(n!⋅n) space in the worst case, where n is the string length.

2nd Solution: Sort both the String and check if they are equal or not.
Time Complexity: O(nlogn)
Space Complexity: O(1)

Optimal Solution: increment the frequency of each character for s1 and decrease the frequency for s2
finally check if frequency array contains all Zeros.
Time Complexity: O(n)
Space Complexity: O(1)
 */