package year2024.december;

import java.util.*;

public class SetMatrixZeroes {
    public static void main(String[] args) {

        /*mat[][] = [[1, -1, 1],
                [-1, 0, 1],
                [1, -1, 1]]*/
        int[][] mat = new int[4][];
        mat[0] = new int[]{0, 1, 2, 0};
        mat[1] = new int[]{3, 4, 5, 2};
        mat[2] = new int[]{0, 1, 4, 5};
        mat[3] = new int[]{2, 6, 8, 9};
        for (int[] arr : mat) {
            System.out.println("Original: " + Arrays.toString(arr));
        }

        setMatrixZeroes(mat);
        for (int[] arr : mat) {
            System.out.println("Result: " + Arrays.toString(arr));
        }

    }

    private static void setMatrixZeroes(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean rowZero = false;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (mat[row][col] == 0) {
                    mat[0][col] = 0;
                    if (row == 0) {
                        rowZero = true;
                    } else {
                        mat[row][0] = 0;
                    }
                }
            }
        }
        //make all rows and columns zero which contain zero except first row and first column
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (mat[0][col] == 0 || mat[row][0] == 0) {
                    mat[row][col] = 0;
                }
            }
        }
        //make first column zero
        if (mat[0][0] == 0) {
            for (int row = 0; row < n; row++) {
                mat[row][0] = 0;
            }
        }
        //make first row zero
        if (rowZero) {
            for (int col = 0; col < m; col++) {
                mat[0][col] = 0;
            }
        }
    }
}
/*
Solution1: Brute Force Solution
Time complexity: O((n*m)(n+m))
Space complexity: O(n*m)

Solution2: Improved Solution
Store the rows and columns having zeros O(n*m)
set the rows to zeros having zeros O(n*m)
set the columns to zeros having zeros O(n+m)
Time complexity: O(n*m)
Space complexity: O(n+m)

Solution3: Optimal Solution
Intuition: Instead of using extra space for store the rows having zeros, we will use first column.
for storing the columns having zeros we will use zeroth row.
for 00 it will overlap, so we will use one extra variable for 0 row.
Time complexity: O(n*m)
Space complexity: O(n+m)
 */