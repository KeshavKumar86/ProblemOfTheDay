package year2025.january;

import java.util.HashMap;

public class LargestSubarrayOf0And1 {
    public static void main(String[] args) {

        //arr[] = [1, 0, 1, 1, 1, 0, 0]
        int[] arr = new int[]{1, 0, 1, 1, 1, 0, 0};
        System.out.println("Result: " + maxLenII(arr));
    }

    private static int maxLen(int[] arr) {
        // Your code here
        int n = arr.length;
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefixSum += (arr[i] == 0 ? -1 : 1);
            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    private static int maxLenII(int[] arr) {

        int diff = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            diff += arr[i] == 0 ? -1 : 1;
            if (map.containsKey(diff)) {
                maxLength = Math.max(maxLength, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return maxLength;
    }
}
/*
Solution1: Brute Force Solution
Generate every subarray using 2 loops and count no of 1's, if the size == 2*no of 1's then take the
length and compare with max.
Time Complexity: O(n^2)
Space Complexity: O(1)

Solution2: Optimal Solution
Replace every 0's with -1. Now question is boiled down to find the longest subarray with 0 sum.
We can find that using Hashmap and prefixSum. check if prefixSum is already present, if it is already
present that count the length, and do not put this prefixSum(it will reduce the length). Compare
the length with maxLength.
Time Complexity: O(n)
Space Complexity: O(n)
 */
