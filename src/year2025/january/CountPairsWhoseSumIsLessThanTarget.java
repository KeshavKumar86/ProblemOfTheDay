package year2025.january;

import java.util.Arrays;

public class CountPairsWhoseSumIsLessThanTarget {
    public static void main(String[] args) {

        // arr[] = [7, 2, 5, 3], target = 8
        int[] arr = new int[]{2, 1, 8, 3, 4, 7, 6, 5};
        int target = 7;
        System.out.println("Result: " + countPairs(arr, target));
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
