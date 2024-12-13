package year2024.december;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {

        int[] a = {0, 1};
        int[] b = {2, 3};
        System.out.println("Original a: " + Arrays.toString(a));
        System.out.println("Original b: " + Arrays.toString(b));
        mergeArrays(a, b);
        System.out.println("Original a: " + Arrays.toString(a));
        System.out.println("Original b: " + Arrays.toString(b));

    }

    private static void mergeArrays(int[] a, int[] b) {

        //naive Solution using extra space
        int n = a.length;
        int m = b.length;
        int[] tempa = new int[n];
        int[] tempb = new int[m];
        System.arraycopy(a, 0, tempa, 0, n);
        System.arraycopy(b, 0, tempb, 0, m);
        int i = 0, j = 0, y = 0, z = 0;
        while (i < n && j < m) {
            if (y != n) {
                if (tempa[i] <= tempb[j]) {

                    a[y++] = tempa[i++];
                } else {
                    a[y++] = tempb[j++];
                }
            } else {
                if (tempa[i] <= tempb[j]) {

                    b[z++] = tempa[i++];
                } else {
                    b[z++] = tempb[j++];
                }
            }
        }
        while (i < n) {
            if (y != n) {
                a[y++] = tempa[i++];
            } else {
                b[z++] = tempa[i++];
            }
        }
        while (j < m) {
            if (y != n) {
                a[y++] = tempb[j++];
            } else {
                b[z++] = tempb[j++];
            }
        }

    }
}
/*
Solution1: Naive approach
1.make one temp array of size n+m and copy a and b into temp.
2.sort the temp
3.copy first n elements to a and last m elements to b.
Time Complexity: O((n+m)log(n+m))
Space Complexity: O(n+m)

Solution2: better than naive using extra space but leveraging the utility of merge procedure
1.make 2 temp arrays tempa and tempb and copy a and b into these arrays
2.use merge procedure to complete the task
Time Complexity: O(n+m)
Space Complexity: O(n+m)

Solution3: optimal approach without using extra space


 */
