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

        List<Integer> rows = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    if (rows.isEmpty()) {
                        rows.add(i);
                    } else {
                        if (rows.get(rows.size() - 1) != i) {
                            rows.add(i);
                        }
                    }
                    set.add(j);
                }

            }
        }
        //make all rows zero which contain zero
        for (int row : rows) {
            for (int j = 0; j < m; j++) {
                mat[row][j] = 0;
            }
        }
        //make all column zero which contain zero
        for (int col : set) {
            for (int i = 0; i < n; i++) {
                mat[i][col] = 0;
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
 */