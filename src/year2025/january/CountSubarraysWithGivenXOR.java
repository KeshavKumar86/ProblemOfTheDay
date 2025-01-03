package year2025.january;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenXOR {
    public static void main(String[] args) {

        //arr[] = [4, 2, 2, 6, 4], k = 6
        int[] arr = new int[]{5, 6, 7, 8, 9};
        int k = 5;
        System.out.println("Result: " + subarrayXor(arr, k));
    }

    private static long subarrayXor(int[] arr, int k) {

        int prefixXOR = 0;
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int element : arr) {
            prefixXOR = prefixXOR ^ element;
            if (map.containsKey(k ^ prefixXOR)) {
                count += map.get(k ^ prefixXOR);
            }
            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
        }
        return count;
    }
}
/*
Solution1: Brute Force
Approach: Check all possible subarrays and compute their xor.
Iterate through all possible subarrays using two nested loops.
For each subarray, calculate its xor.
Increment the count if the xor equals k.
Time Complexity: O(n^3)
Space Complexity: O(1)

Solution2: Improved Brute Force
Check for every subarray if the xor is equal to target, if it is increment the result by 1.
for(int i=0;i<n;i++)
{ int xor = 0;
for(int j = i;j<n;j++)
{
xor += arr[j]
if(xor == target)
{
count++;
}
}
}
Time complexity: O(n*n)
Space complexity: O(1)

Solution3: Optimal Solution
Intuition: Use prefix XOR and hashing
As we know a^b=c that means b^c=a, so if target^prefixXOR = element is present in hash that means
element^prefixXOR = target, that means from next to element till prefixXOR, xor will be equal to
target.
Time complexity: O(n)
Space complexity: O(n)
 */