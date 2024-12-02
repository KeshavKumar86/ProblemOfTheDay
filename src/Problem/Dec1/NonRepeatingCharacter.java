package Problem.Dec1;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "aabbcc";
        System.out.println("Result: " + nonRepeatingChar(s));

    }

    static char nonRepeatingChar(String s) {

        int[] arr = new int[26];
        //below is a linear time operation
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        //below is a linear time operation
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] == 1) {
                return c;
            }
        }
        return '$';
    }
}
/*
Brute-Force Solution: using 2 loops checks if one character repeats(O(n)), and do it for every
character(O(n)) present in the String
Optimal Solution:  The array-based approach is the most optimal in both time and space for this
specific problem (limited to lowercase Latin letters)
 */