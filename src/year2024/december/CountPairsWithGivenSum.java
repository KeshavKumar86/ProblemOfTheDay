package year2024.december;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {

        //arr[] = [1, 5, 7, -1, 5], target = 6
        int[] arr = new int[]{5, 6, 5, 7, 7, 8};
        int target = 13;
        System.out.println("Result: " + countPairs(arr, target));

    }

    static int countPairs(int[] arr, int target) {

        int result = 0;
        int sameCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : arr) {
            int value = target - element;
            if (value == element) {
                sameCount++;
            } else {
                if (map.containsKey(value)) {
                    int freq = map.get(value);
                    result = result + freq;
                }
                map.put(element, map.getOrDefault(element, 0) + 1);
            }

        }
        return (result + ((sameCount * (sameCount - 1)) / 2));
    }
}
/*
Solution1: Brute force Solution
Run 2 loop and take every possible pair and check if it satisfies the condition, and if it satisfies
then increase result by 1.
Time complexity: O(n*n)
Space complexity: O(1)

Solution2: Using Binary Search
Sorting and Binary Search - O(n*log(n)) time and O(1) space, to search we will use binary search
instead of liner search as in solution 1.
Time complexity: O(nlogn)
Space complexity: O(1)

Solution3: Optimal Solution
Use HashMap to store the element and their frequencies
Time complexity: O(n)
Space complexity: O(n)
 */