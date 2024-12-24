package year2024.december;

public class SearchInASortedMatrix {
    public static void main(String[] args) {

        //mat[][] = [[1, 5, 9], [14, 20, 21], [30, 34, 43]], x = 14
        int[][] arr = new int[3][];
        arr[0] = new int[]{1, 5, 9};
        arr[1] = new int[]{14, 20, 21};
        arr[2] = new int[]{30, 34, 43};
        int x = 9;

        System.out.println("Search Result: " + searchMatrix(arr, x));

    }

    private static boolean searchMatrix(int[][] mat, int x) {

        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int column = mid % m;
            if (mat[row][column] == x) {
                return true;
            } else if (mat[row][column] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
/*
Solution1: Naive Approach Brute force Approach
Iterate every element and compare it with target, if found return true else return false
Time complexity: O(n*m)
Space complexity: O(1)

Solution2: Better Solution
start from the top-right corner
check if x is less than the element,
  if x is less move left
  if x is greater move bottom.
Time complexity: O(n+m)
Space complexity: O(1)

Solution3: Optimal Solution (Using binary search twice)
take last column and low = 0 and high = n-1 and find the row that should have element.
then use binary search to search that element in that particular row.
Time complexity: O(logn + logm)
logn - To find the row that should have that element
logm - To find the element in that particular row.
Space complexity: O(1)

Solution4: Optimal Solution (using binary search once)
Take low = 0 and high = n*m-1
find middle and apply below formula to find the row and column
row = middle/no of column;
column = middle%no of column;
Apply binary search logic.
Time complexity: O(logn*m)
Space complexity: O(1)


 */