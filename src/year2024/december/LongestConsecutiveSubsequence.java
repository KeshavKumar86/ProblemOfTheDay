package year2024.december;

import java.util.Arrays;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {

        //arr[] = [2, 6, 1, 9, 4, 5, 3]
        int[] arr = new int[]{0, 1, 1, 1, 2, 3, 4, 5, 7, 8};
        int result = longestConsecutive(arr);
        System.out.println("Result: " + result);
    }

    private static int longestConsecutive(int[] arr) {

        Arrays.sort(arr);
        int n = arr.length;
        int maxLength = 1;
        int length = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]) {
                length++;
            } else if (arr[i] == arr[i + 1]) {
                continue;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
        }
        return Math.max(maxLength, length);
    }
}
/*
Solution1: Using Sorting
1.Sort the array
2.count the consecutive elements, use one variable maxLength to check if this consecutive sequence
has max length than the known maximum.
Time complexity: O(nlogn)
Space complexity: O(1)

Solution2: Optimal Solution
*/