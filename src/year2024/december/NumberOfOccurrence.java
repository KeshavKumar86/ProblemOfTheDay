package year2024.december;

public class NumberOfOccurrence {
    public static void main(String[] args) {

        int[] arr = {1};
        int target = 1;
        System.out.println("Result: " + countFreq(arr, target));

    }

    static int countFreq(int[] arr, int target) {

        int start = startSearch(arr, target);
        int end = endSearch(arr, target);
        if (start == -1) {
            return 0;
        }
        return end - start + 1;
    }

    static int startSearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;

                } else {
                    right = mid - 1;
                }
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static int endSearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            if (arr[mid] == target) {
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
/*
First Solution: Brute Force Approach (Naive Approach)
using linear search: iterate the array and check if arr[i] is equal to target, if it is than
increase frequency by 1
Time complexity: O(n)
Space complexity: O(1)

Second Solution: Optimal Solution using binary search because array is sorted
Using Binary search: because array is sorted we can make use of binary search
First find the starting index using binary search
if(arr[mid] == target) and
if (mid == 0 || arr[mid - 1] != target)
then mid is the start index
else search on the left side right = mid - 1;
second find the ending index using binary search
if(arr[mid] == target) and
if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;//search on the right side
                }
Time complexity: O(logn)
Space complexity: O(1)
 */

