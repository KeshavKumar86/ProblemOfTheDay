package year2024.december;

import java.util.Arrays;

public class Sort01And2s {
    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println("Original: " + Arrays.toString(arr));
        sort012(arr);
        System.out.println("Result: " + Arrays.toString(arr));

    }

    private static void sort012(int[] arr) {

        int zerop = 0, onep = 0, twop = arr.length - 1;
        while (onep <= twop) {
            if (arr[onep] == 0) {
                int temp = arr[onep];
                arr[onep] = arr[zerop];
                arr[zerop] = temp;
                onep++;
                zerop++;
            } else if (arr[onep] == 2) {
                int temp = arr[onep];
                arr[onep] = arr[twop];
                arr[twop] = temp;
                twop--;
            } else {
                onep++;
            }
        }
    }
}
/*
Solution1: 1. Naive Approach (Sorting using Library Function)
Simply sort the array using a standard sorting algorithm like QuickSort or MergeSort.

Algorithm
Use the in-built sort function (Arrays.sort in Java).
Since the array contains only 0s, 1s, and 2s, sorting will arrange them in ascending order.
Time Complexity
O(n log n) (due to sorting).

Solution2: 2. Counting Approach
Count the number of 0s, 1s, and 2s and then rewrite the array based on these counts.

Algorithm
Traverse the array and count the occurrences of 0s, 1s, and 2s.
Overwrite the array with 0s, followed by 1s, and then 2s.
Time Complexity
O(n) (one pass to count + one pass to overwrite).
Space Complexity
O(1) (in-place

Solution3: 3. Dutch National Flag Algorithm (Optimal Approach)
This approach uses three pointers to partition the array into three segments for 0s, 1s, and 2s.

Algorithm
Initialize three pointers:
low for 0s.
mid for 1s.
high for 2s.
Traverse the array using the mid-pointer:
If the element is 0, swap it with the element at low and increment both low and mid.
If the element is 1, just increment mid.
If the element is 2, swap it with the element at high and decrement high.
Continue until mid <= high.
Time Complexity
O(n) (single traversal).
Space Complexity
O(1) (in-place).

 */