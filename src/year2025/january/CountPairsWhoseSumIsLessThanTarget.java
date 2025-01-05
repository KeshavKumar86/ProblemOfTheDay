package year2025.january;

import java.util.Arrays;

public class CountPairsWhoseSumIsLessThanTarget {
    public static void main(String[] args) {

        // arr[] = [7, 2, 5, 3], target = 8
        int[] arr = new int[]{2, 1, 8, 3, 4, 7, 6, 5};
        int target = 7;
        System.out.println("Result: " + countPairsII(arr, target));
    }

    static int countPairsII(int[] arr, int target) {

        Arrays.sort(arr);
        int count = 0;
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum >= target) {
                high--;
            } else {
                count += (high - low);
                low++;
            }
        }
        return count;
    }

    static int countPairs(int[] arr, int target) {

        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = binarySearch(arr, (target - arr[i]));
            if ((count - (i + 1)) > 0) {
                result = result + (count - (i + 1));
            } else {
                break;
            }

        }
        return result;
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return high + 1;
    }
}
/*
Solution1: Brute Force Solution
Generate every pair using 2 loops and check if sum is less than target, is sum is less than target
increase the count by 1.
Time complexity: O(n^2)
Space complexity: O(1)

Solution2: Better Solution(using binary search)
Intuition: iterate through every element of the array, while iterating check the number of elements
having value less than target-arr[i], to the right of arr[i] and add them into the result.
Formula to get all elements less than target-arr[i] = binary search
to fetch elements less than target-arr[i], to the right of arr[i] : count-(i+1)
if count-(i+1) is less or equal to zero that means no elements less than target-arr[i] to the right of
arr[i], so break the loop.
Time complexity: O(2*nlogn)
Space complexity: O(1)

Solution3: Optimal Solution ( using 2 pointers)
Intuition: First sort the array, then use Two Pointers Technique to find the number of pairs with a sum
less than the given target. Initialize two pointers, one at the beginning (left) and the other at the
end (right) of the array. Now, compare the sum of elements at these pointers with the target:

If sum < target:
Pairs formed by the element at the left pointer with every element between left and right
(inclusive) will have a sum less than the target. Therefore, we add (right - left) to the count
and move the left pointer one step to the right to explore more pairs.
If sum >= target:
We move the right pointer one step to the left to reduce the sum.
Time complexity: O(nlogn + n)
Space complexity: O(1)
 */