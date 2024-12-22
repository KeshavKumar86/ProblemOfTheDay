package year2024.december;

public class SearchInARowColumnSortedMatrix {
    public static void main(String[] args) {

        int[][] arr = new int[3][];
        arr[0] = new int[]{3, 30, 38};
        arr[1] = new int[]{20, 52, 54};
        arr[2] = new int[]{35, 60, 69};
        int x = 69;

        System.out.println(matSearch(arr, x));

    }

    private static boolean matSearch(int[][] mat, int x) {

        int n = mat.length;
        int m = mat[0].length;
        if(n<=m){
            for (int[] ints : mat) {
                if (rowBinarySearch(ints, x)) {
                    return true;
                }
            }
        }
        else{
            for(int col=0;col<m;col++){
                if(columnBinarySearch(mat,col,x)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean rowBinarySearch(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    private static boolean columnBinarySearch(int[][] arr,int column, int target) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid][column] == target) {
                return true;
            } else if (arr[mid][column] > target) {
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

Solution2: Because every row is sorted use binary search for searching in every row
Iterate every row and use binary search to search target in every row.
Time complexity: O(n*logm)
Space complexity: O(1)

Solution3: Because every row and column is sorted use binary search for searching in every row or
column depending on which is small.
if no. of row is small - use binary search on row.
if no. of column is small - use binary search on column.
 */