package year2024.december;

public class CountInversions {
    public static void main(String[] args) {

        int[] arr = {6, 5, 4, 3, 2, 1};
        System.out.println("Result: " + inversionCountOptimal(arr));
    }

    static int inversionCountOptimal(int[] arr) {

        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            count += mergeSort(arr, l, mid);
            count += mergeSort(arr, mid + 1, r);
            count += mergeAndCount(arr, l, mid, r);
        }
        return count;
    }

    private static int mergeAndCount(int[] arr, int l, int mid, int r) {

        int count = 0;
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j;
        for (i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }
        i = 0;
        j = 0;
        int k = l;
        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count = count + (n1 - i);
            }

        }
        while (i < n1) {
            arr[k++] = left[i++];

        }
        while (j < n2) {
            arr[k++] = right[j++];

        }
        return count;
    }

    static int inversionCount(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }

}
/*
Solution1: BruteForce Solution
for every element count the element greater than that element on the right side of it.
Time Complexity: O(n*n)
Space Complexity: O(1)

Solution2: 2. Optimal Solution Using Merge Sort
This approach uses a modified merge sort algorithm to count inversions while sorting the array.

Key Insight: During the merge step, if an element from the right subarray is smaller than an element
from the left subarray, then all remaining elements in the left subarray will form inversions with
this element.

Algorithm:
Split the array recursively into two halves until each subarray has one element.
While merging the two halves:
Count inversions when an element from the right subarray is placed before an element from the left
subarray.
The total inversion count is the sum of:
Inversions in the left half.
Inversions in the right half.
Inversions counted during merging.
Time Complexity: O(nlogn)
Space complexity: O(n) for merge procedure
 */