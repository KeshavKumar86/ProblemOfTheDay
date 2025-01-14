package year2025.january;

import java.util.Arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {

        //arr[] = [1, 2, 0, 3]
        int[] arr = new int[]{2, 1, -1};
        System.out.println("Result: " + findEquilibrium(arr));
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
