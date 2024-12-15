package year2024.december;

public class NonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "aabbccc";
        System.out.println("Result: " + nonRepeatingChar(s));

    }

    static char nonRepeatingChar(String s) {

        int[] arr = new int[26];
        //below is a linear operation
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (arr[index] != 0) {
                arr[index] = -1;
            } else {
                arr[index] = i + 1;
            }
        }
        //below is a constant operation
        //find the non-repeated character having minimum index(String mai phle aaya hoga)
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value != 0 && value != -1) {
                if (value < min) {
                    min = value;
                }

            }
        }
        if (min != Integer.MAX_VALUE)
            return s.charAt(min - 1);
        return '$';
    }

/*
Brute-Force Solution: using 2 loops checks if one character repeats(O(n)), and do it for every
character(O(n)) present in the String
Time complexity: O(n*n)
Space complexity: O(1)

Optimal Solution1:  Using 2 iterations
The array-based approach is the most optimal in both time and space for this
specific problem (limited to lowercase Latin letters)
Time complexity: O(n)
Space complexity: O(1)

Optimal Solution2:  Using 1 iteration
Store the index+1 of characters occurring only one time in the string
characters not occurring will have 0.
characters occurring more than 1 time will have 0.
now in the characters having frequency 1 return the minimum index.
Time complexity: O(n)
Space complexity: O(1)
 */
}
