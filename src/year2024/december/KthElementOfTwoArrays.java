package year2024.december;

public class KthElementOfTwoArrays {
    public static void main(String[] args) {

        int[] a = {2};
        int[] b = {1};
        int k = 2;
        int result = kthElement(a, b, k);
        System.out.println("Result: " + result);
    }

    private static int kthElement(int[] a, int[] b, int k) {

        int n = a.length;
        int m = b.length;
        int pt1 = 0;
        int pt2 = 0;
        int pt3 = 0;
        int[] res = new int[n + m];
        while (pt1 < n && pt2 < m) {
            if (a[pt1] <= b[pt2]) {
                res[pt3++] = a[pt1++];
            } else {
                res[pt3++] = b[pt2++];
            }
        }
        while (pt1 < n) {
            res[pt3++] = a[pt1++];
        }
        while (pt2 < m) {
            res[pt3++] = b[pt2++];
        }
        return res[k - 1];

    }
}
/*
Solution1: Naive Solution using sorting
1.Create new array of size n+m.
2.copy elements of a and b into this.
3.Sort this array
4.return arr[k-1].
Time Complexity: O((n+m)log(n+m))
Space complexity: O(n+m)

Solution 2: Improved Naive Solution using merge Procedure
1.Create new array of size n+m.
2.Copy the elements of a and b into arr using merge procedure.
3.return arr[k-1].
Time Complexity: O(n+m)
Space complexity: O(n+m)

Solution3: Improved Naive Solution using merge procedure without using extra space and running the loop
only k times

Solution4: Optimal Solution (Hard)
Time complexity: O(log(min(n,m)))
Space Complexity: O(1).
 */
