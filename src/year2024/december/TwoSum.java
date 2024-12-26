package year2024.december;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {

        //arr[] = [1, 4, 45, 6, 10, 8], target = 16
        int[] arr = new int[]{1, 4, 45, 6, 10, 8};
        int target = 8;
        System.out.println("Result: " + twoSum(arr, target));
    }

    private static boolean twoSum(int[] arr, int target) {

        Set<Integer> set = new HashSet<>();
        for (int element : arr) {
            int value = target - element;
            if (set.contains(value)) {
                return true;
            } else {
                set.add(element);
            }
        }
        return false;
    }
}
/*
Solution1: [Naive Approach]
Generating all Possible Pairs - O(n^2) time and O(1) space

Solution2: [Better Approach 1]
Sorting and Binary Search - O(n*log(n)) time and O(1) space

Solution3: [Better Approach 2]
Sorting and Two-Pointer Technique - O(n*log(n)) time and O(1) space

Solution4: [Expected Approach]
Using Hash Set - O(n) time and O(n) space
 */