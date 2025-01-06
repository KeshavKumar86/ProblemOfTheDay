package year2025.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairClosestToTarget {
    public static void main(String[] args) {

        //arr[] = [10, 30, 20, 5], target = 25
        int[] arr = new int[]{5, 2, 7, 1, 4};
        int target = 10;
        System.out.println("Result: " + sumClosest(arr, target));
    }

    private static List<Integer> sumClosest(int[] arr, int target) {

        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int low = 0, high = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (Math.abs(target - sum) < minDiff) {
                minDiff = Math.abs(target - sum);
                list = Arrays.asList(arr[low], arr[high]);
            }
            if (sum > target) {
                high--;
            } else if (sum < target) {
                low++;
            } else {
                break;
            }

        }
        return list;
    }
}
/*
Solution1: Brute Force Solution
generate every pair using 2 loops and for every pair check is the sum is more close to target if it is
update the minDiff and result list.
Time Complexity: O(n^2)
Space Complexity: O(1)

Solution2: Better than Naive (Using binary search)
Time complexity: O(nlogn + nlogn)
Space complexity: O(1)

Solution3: Optimal Solution (using 2 pointer technique)
Intuition: The idea is to sort the array and use Two Pointer Technique to find the pair with sum
closest to target. Initialize a pointer left to the beginning of the array and another pointer right
to the end of the array. Now, compare the sum at both the pointers to find the pair sum closest to
target:

If arr[left] + arr[right] < target: We need to increase the pair sum, so move left to higher value.
If arr[left] + arr[right] > target: We need to decrease the pair sum, so move right to smaller value.
If arr[left] + arr[right] == target: We have found a pair with sum = target, so we can return the pair.
Time complexity: O(nlogn + n)
Space complexity: O(1)
 */