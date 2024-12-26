package year2024.Days160BonusProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayInThreeEqualSumSubarrays {
    public static void main(String[] args) {

        //arr[] = [1, 3, 4, 0, 4]
        int[] arr = {3, 2, 4};
        List<Integer> result = findSplit(arr);
        System.out.println("Result: " + result);
    }

    private static List<Integer> findSplit(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int sum = Arrays.stream(arr).sum();
        list.add(-1);
        list.add(-1);
        if (sum % 3 != 0) {
            return list;
        }

        int targetSum = sum / 3;
        int commulativeSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((commulativeSum + arr[i]) < targetSum) {
                commulativeSum += arr[i];
            } else if ((commulativeSum + arr[i]) == targetSum) {
                if (list.get(0) == -1) {
                    list.set(0, i);
                } else {
                    list.set(1, i);
                    return list;
                }
                commulativeSum = 0;
            }
        }

        if (list.get(1) == -1) {
            list.set(0, -1);
        }
        return list;
    }
}
/*
Solution1: Optimal Solution
Find the total sum and check if it is divisible by 3, if it is than solution is possible otherwise
return -1,-1.
If it is divisible by 3 than we have to find 3 consecutive sub-arrays which has sum = totalSum/3;
Start from index 0 and calculate cumulative sum if it is equal to target we got our first subarray.
Add this index to result, and make cumulative sum zero again to find the second subarray.
Repeat the same process and when we find the second subarray break the loop or return the result.
Time Complexity: O(n)
Space complexity : O(1)
 */