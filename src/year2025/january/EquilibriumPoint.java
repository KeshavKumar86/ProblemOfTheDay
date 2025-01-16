package year2025.january;

import java.util.Arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {

        //arr[] = [1, 2, 0, 3]
        int[] arr = new int[]{-7, 1, 5, 2, -4, 3, 0};
        System.out.println("Result: " + findEquilibriumNaive(arr));
    }

    private static int findEquilibriumNaive(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //find the leftSum
            int leftSum = 0, rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int k = i + 1; k < n; k++) {
                rightSum += arr[k];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    private static int findEquilibrium(int[] arr) {

        int pivot = 0;
        int leftSum = 0;
        int rightSum = Arrays.stream(arr).sum() - arr[0];
        while (pivot < arr.length - 1 && leftSum != rightSum) {
            leftSum += arr[pivot];
            pivot++;
            rightSum -= arr[pivot];

        }
        if (leftSum == rightSum) {
            return pivot;
        }
        return -1;
    }
}
/*
Solution1: Brute Force Solution
Iterate the array using i, for every i calculate sum of the elements before it and sum of the
elements after it. if sum is equal return i, else return -1;
Time Complexity: O(n^2)
Space complexity: O(1)

Solution2: Optimal Solution
1.Calculate the sum from index 1 as rightSum.
take leftSum as 0 initially.
from index 0 iterate the array and check if leftSum == rightSum, if it is not add arr[i] in leftSum
and increase i and subtract arr[i] from rightSum.
Time Complexity: O(n)
Space complexity: O(1)
 */