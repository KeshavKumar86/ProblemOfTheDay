package year2024.december;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        System.out.println("Original a: " + Arrays.toString(a));
        merge(a, 3, b, b.length);
        System.out.println("After merging a: " + Arrays.toString(a));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        if (i < 0) {
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }
}

/* Question:
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers
m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array
nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a
length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.


Solution:
Solution1: Naive Solution:
1.just replace any m elements of num1 with elements of num2
2.sort the num1
Time complexity: O(nlog(n))
Space complexity: O(1)

Solution2: better than naive using extra space but leveraging the utility of merge procedure
1.copy the elements of num1 into temp array
2.use merge procedure on temp array and num2 and put the resulted element in num1
Time complexity: O(n+m)
Space complexity: O(n)

Solution3: optimal Solution without using extra space
Time complexity: O(n+m)
Space complexity: O(1)
 */
