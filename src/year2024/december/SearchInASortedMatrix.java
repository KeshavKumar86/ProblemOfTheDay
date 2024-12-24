package year2024.december;

public class SearchInASortedMatrix {
    public static void main(String[] args) {

        //mat[][] = [[1, 5, 9], [14, 20, 21], [30, 34, 43]], x = 14
        int[][] arr = new int[3][];
        arr[0] = new int[]{1, 5, 9};
        arr[1] = new int[]{14, 20, 21};
        arr[2] = new int[]{30, 34, 43};
        int x = 15;

        System.out.println("Search Result: " + searchMatrix(arr, x));

    }

    private static boolean searchMatrix(int[][] mat, int x) {

        //linear search
        int n = mat.length;
        int m = mat[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            } else if (mat[i][j] > x) {
                //move left
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
/*
Solution1: Naive Solution
start from the top-right corner
check if x is less than the element,
  if x is less move left
  if x is greater move bottom.
Time complexity: O(n+m)
Space complexity: O(1)

Solution2: optimal Solution

 */