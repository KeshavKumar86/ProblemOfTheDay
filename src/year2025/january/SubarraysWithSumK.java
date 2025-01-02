package year2025.january;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithSumK {
    public static void main(String[] args) {

        //arr = [10, 2, -2, -20, 10], k = -10
        int[] arr = new int[]{2, 4, -6, 2, 3, 4, -9, 0, 2, -2, 0};
        int k = 0;
        System.out.println("Result: " + countSubarrays(arr, k));
    }

    private static int countSubarrays(int[] arr, int k) {

        long prefixSum = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        int result = 0;
        for (int element : arr) {
            prefixSum += element;
            if (map.containsKey(prefixSum - k)) {
                result += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}
/*
Solution1: Brute Force Solution
Check for every subarray if the sum is equal to target, if it is increment the result by 1.
for(int i=0;i<n;i++)
{ int sum = arr[i];
for(int j = i+1;j<n;j++)
{
sum += arr[i]
if(sum == target)
{
count++;
}
}
}
Time complexity: O(n*n)
Space complexity: O(1)

Solution2: Optimal Solution
Intuition: Use prefix sum and hashing
prefixSum1 + target = prefixSum2, it means that prefixSum2 - target is equal to prefixSum1.
we will put every prefixSum into map with frequency and check if the prefixSum2-target is present
in the map, if it presents that means sum from prefixSum1 to prefixSum2 is equal to target, so we will
add in the result the frequency of the prefixSum1.
Time complexity: O(n)
Space complexity: O(1)
 */