package year2025.january;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {

        //arr[] = [10, 5, 2, 7, 1, -10], k = 15
        int[] arr = new int[]{10, 5, 2, 7, 1, -10, -5, 5};
        int k = 15;
        System.out.println("Result: " + longestSubarray(arr, k));
    }

    private static int longestSubarray(int[] arr, int k) {

        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (map.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, (i - map.get(prefixSum - k)));
            }
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);
        }
        return maxLength;
    }
}
/*
Solution1: Brute Force Solution
Iterate for every subarray using 2 loops and checks if sum is equal to k, if it is equal to K count
its length and compare with maxLength, if it is greater than maxLength then update the maxLength.
Time Complexity: O(n^2)
Space Complexity: O(1)

Solution2: Optimal Solution
Use prefixSum and hashing, check is prefixSum-k is present in the map, if it is present count the
length of the subarray and compare with max length, if it is greater than maxLength than update the
maxLength.
Note: if prefixSum is already present in the map than do not put it again, otherwise it will reduce
the length of the longest subarray.
Time Complexity: O(n)
Space Complexity: O(n)
 */