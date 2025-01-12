package year2025.january;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IndexesOfSubarraySum {
    public static void main(String[] args) {

        //arr[] = [1, 2, 3, 7, 5], target = 12
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 15;
        System.out.println("Result: " + subarraySum(arr, target));
    }

    private static ArrayList<Integer> subarraySum(int[] arr, int target) {

        int n = arr.length;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (map.containsKey(prefixSum - target)) {
                int index = map.get(prefixSum - target);
                list.add(index + 2);
                list.add(i + 1);
                return list;
            } else {
                map.put(prefixSum, i);
            }
        }
        list.add(-1);
        return list;
    }
}
/*
Solution1: Brute Force Solution
Iterate every subarray using 2 loops and check if the sum is equal to target, if it is, add the indexes
into the result list and return, if not found then add -1 amd return.
Time Complexity: O(n^2)
Space Complexity: O(1)

Solution2: Optimal Solution (Using sliding window)
Time Complexity: O(n)
Space Complexity: O(1)

Solution3: Alternate Solution (Using Hashing and prefix sum)
Intuition: Calculate prefix sum, if prefix sum till index i is sum1 and till index i+x is sum2, if
sum1 + target = sum2, that means sum of subarray from index i+1 to i+x is equal to target.
sum1 = sum2-target
We will store the prefix sum and index in map, and check if (sum2-target) (prefix sum till index i+x
is present or not.
Time Complexity: O(n)
Space Complexity: O(n)
 */