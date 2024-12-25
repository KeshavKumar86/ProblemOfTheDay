package year2024.december;

import java.util.Arrays;

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

        //make a copy of matrix
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(mat[i], 0, arr[i], 0, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    //make whole row zero
                    for (int k = 0; k < m; k++) {
                        mat[i][k] = 0;
                    }
                    //make whole column zero
                    for (int k = 0; k < n; k++) {
                        mat[k][j] = 0;
                    }
                }
            }
        }
    }
}
/*
Solution1: Brute Force Solution
Time complexity: O((n*m)(n+m))
Space complexity: O(n*m)

Solution2: Little Improved Solution

 */