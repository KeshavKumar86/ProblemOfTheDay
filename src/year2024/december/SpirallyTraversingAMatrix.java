package year2024.december;

import java.util.ArrayList;

public class SpirallyTraversingAMatrix {
    public static void main(String[] args) {
        //mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
        int[][] mat = new int[4][1];
        mat[0] = new int[]{1};
        mat[1] = new int[]{5};
        mat[2] = new int[]{9};
        mat[3] = new int[]{13};
        ArrayList<Integer> result = spirallyTraverse(mat);
        System.out.println(result);

    }

    private static ArrayList<Integer> spirallyTraverse(int[][] arr) {

        int left = 0, top = 0, bottom = arr.length, right = arr[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        while (left < right && top < bottom) {
            //get every i in the top row
            for (int i = left; i < right; i++) {
                list.add(arr[top][i]);
            }
            top++;
            //get every i in the right column
            for (int i = top; i < bottom; i++) {
                list.add(arr[i][right - 1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            //get every i in the bottom row
            for (int i = right - 1; i >= left; i--) {
                list.add(arr[bottom - 1][i]);
            }
            bottom--;
            //get every i in the left column
            for (int i = bottom - 1; i >= top; i--) {
                list.add(arr[i][left]);
            }
            left++;
        }
        return list;
    }
}
/*
Solution1: Optimal Solution(very intuitive)
1.First traverse the entire top row and when you reached the last column, increase the top row and
traverse the right column.
2.After traversing the right column, decrease the right column by 1 traverse the bottom row.
3.After traversing the bottom row, decrease the bottom by 1 and traverse the left column.
4.After traversing the left column, increase the left column by 1 and repeat the process for
inner sub-matrix.
Time complexity: O(n*m)
Space complexity: o(1)
 */
