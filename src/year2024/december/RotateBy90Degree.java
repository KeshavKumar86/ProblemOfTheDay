package year2024.december;

import java.util.Arrays;

public class RotateBy90Degree {
    public static void main(String[] args) {

        int[][] arr = new int[3][];
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{4, 5, 6};
        arr[2] = new int[]{7, 8, 9};
        for (int[] element : arr) {
            System.out.println(Arrays.toString(element));
        }
        rotateby90(arr);
        System.out.println("After Rotation:");
        for (int[] element : arr) {
            System.out.println(Arrays.toString(element));
        }
    }

    static void rotateby90(int[][] mat) {

        int n = mat.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                res[n - 1 - j][i] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(res[i], 0, mat[i], 0, n);
        }
    }
}
