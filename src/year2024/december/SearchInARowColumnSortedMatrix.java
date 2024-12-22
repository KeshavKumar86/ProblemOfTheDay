package year2024.december;

public class SearchInARowColumnSortedMatrix {
    public static void main(String[] args) {

        int[][] arr = new int[3][];
        arr[0] = new int[]{1,2,3};
        arr[1] = new int[]{4,5,6};
        arr[2] = new int[]{7,8,9};
        int x = 10;

        System.out.println(matSearch(arr, x));
    }

    private static boolean matSearch(int[][] mat, int x) {

        int n = mat.length;
        int m = mat[0].length;
        int row = 0, column = m-1;
        while(row<n && column>=0){
            if(mat[row][column] == x){
                return true;
            } else if (mat[row][column] > x) {
                column--;
            }
            else {
                row++;
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

Solution2: Because every row is sorted use binary search for searching in every row
Iterate every row and use binary search to search target in every row.
Time complexity: O(n*logm)
Space complexity: O(1)

Solution3: Because every row and column is sorted use binary search for searching in every row or
column depending on which is small.
if no. of row is small - use binary search on row.
if no. of column is small - use binary search on column.
Time complexity: O(min(n⋅logm,m⋅logn))
Space complexity: O(1)

Solution4: Optimal Solution
start from the top-right corner
check if x is less than the element,
  if x is less move left
  if x is greater move bottom.
Time complexity: O(n+m)
Space complexity: O(1)

 */