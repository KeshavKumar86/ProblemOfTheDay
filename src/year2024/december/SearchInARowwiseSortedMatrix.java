package year2024.december;

public class SearchInARowwiseSortedMatrix {
    public static void main(String[] args) {

        // mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
        int[][] arr = new int[3][];
        arr[0] = new int[]{3, 4, 9};
        arr[1] = new int[]{2, 5, 6};
        arr[2] = new int[]{9, 25, 27};
        int x = 28;
        System.out.println(x + " is Present: " + searchRowMatrix(arr, x));
    }

    private static boolean searchRowMatrix(int[][] mat, int x) {

        for (int[] ints : mat) {
            if (binarySearch(ints, x)) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
/*
Solution1: Brute force solution
[Naive Approach] Comparing with all elements – O(n*m) Time and O(1) Space
The simple idea is to traverse the complete matrix and search for the target element. If the target
element is found, return true. Otherwise, return false.
Time complexity: O(n*m)
Space complexity: O(1)

Solution2: Optimal Solution Using Binary search
The idea is simple, we traverse through the matrix and apply binary search on each row to find
the element.
Time complexity: O(n*logm)
Space complexity: O(1)
 */