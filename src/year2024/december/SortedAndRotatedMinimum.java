package year2024.december;

public class SortedAndRotatedMinimum {
    public static void main(String[] args) {

        int[] arr = {5, 6, 1, 2, 3, 4};
        int result = findMin(arr);
        System.out.println("Result: " + result);
    }

    private static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            if (arr[mid] > arr[arr.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[right + 1];
    }
}
/*
Solution1: Naive Solution using linear search
Time complexity: O(n)
space complexity: O(1)

Solution2: Optimal Solution using binary search
1.calculate mid
2.if mid is greater than the arr[arr.length-1] then we are in the first half
we have to move to the right (left = mid+1)
3.if mid is less than the arr[arr.length-1] then we are in the second half
we have to move to the left (right = mid-1)
Time complexity: O(logn)
space complexity: O(1)
 */