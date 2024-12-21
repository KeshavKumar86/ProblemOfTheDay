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
