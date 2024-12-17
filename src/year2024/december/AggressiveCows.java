package year2024.december;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {

        int[] arr = {2, 12, 11, 3, 26, 7};
        int cow = 3;
        int result = aggressiveCows(arr, cow);
        System.out.println("Result: " + result);
    }

    public static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);
        int n = stalls.length;
        int max = stalls[n - 1];
        int min = stalls[0];
        //edge case
        if (k == 1) {
            return max - min;
        }
        for (int i = 1; i <= (max - min); i++) {
            if (!isPossible(stalls, i, k)) {
                return i - 1;
            }
        }
        return 0;
    }

    private static boolean isPossible(int[] arr, int distance, int cows) {

        int countCow = 1;
        int lastPlaced = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlaced >= distance) {
                countCow++;
                lastPlaced = arr[i];
            }
            if (countCow >= cows) {
                return true;
            }
        }
        return false;
    }

}
/*
Solution1: Naive Solution using linear search
Time Complexity: O((max-min)*n) roughly equal to O(n*n) quadratic complexity
Space complexity: O(1)
 */
