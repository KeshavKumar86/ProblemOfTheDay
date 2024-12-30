package year2024.december;

import java.util.Arrays;

public class RotateBy90Degree {
    public static void main(String[] args) {

        int[][] arr = new int[2][];
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{3, 4};
        for (int[] element : arr) {
            System.out.println(Arrays.toString(element));
        }
        rotateBy90(arr);
        System.out.println("After Rotation:");
        for (int[] element : arr) {
            System.out.println(Arrays.toString(element));
        }
    }

    static void rotateBy90(int[][] mat) {

        int n = mat.length;
        //first transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //reverse every column
        for (int col = 0; col < n; col++) {
            int low = 0, high = n - 1;
            while (low <= high) {
                int temp = mat[low][col];
                mat[low][col] = mat[high][col];
                mat[high][col] = temp;
                low++;
                high--;
            }
        }
    }
}
/*
Solution1: Naive Solution
Intuition: Use a different matrix to set the rotated value.
Start row by row from the last column to first column, and put in the different matrix column by
column from top to bottom.
Copy the rotated values back to the original array
Time complexity: O(n*m) 2 iteration
Space Complexity: O(n*m)

Solution2: Optimal Solution
Intuition: Take the transpose of the matrix and, and rotate each column from left to right.
Time Complexity: O(n*m) 2 iteration
Space complexity: O(1)

Solution3: Optimal Solution
 */