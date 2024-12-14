package year2024.december;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {

        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        System.out.println("Original a: " + Arrays.toString(a));
        System.out.println("Original b: " + Arrays.toString(b));
        mergeArrays(a, b);
        System.out.println("Sorted a: " + Arrays.toString(a));
        System.out.println("Sorted b: " + Arrays.toString(b));

    }

    private static void mergeArrays(int[] a, int[] b) {

        int n = a.length, m = b.length;
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < n && j < m) {
            if (a[i] > b[j]) {
                // Swap elements
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
            }
            i++;
        }

        // Sort the second array b[] to maintain order
        Arrays.sort(b);    }
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

Solution3:
Steps
Iterate the Array a[] using pointer i.
Compare a[i] and b[0]. If a[i] > b[j], swap them. ( this means this a[i] should be in b array because it
is greater than the smallest element in b(b[0]))
After a swap, use insertion sort logic to re-position b[j] in b[] to maintain its sorted order.(After
this step also we will have sorted b that means b[0] will be the smallest.
Time Complexity: O(n*m)
Space Complexity: O(1)

Solution4: optimal approach1 without using extra space
1.Start from last of a and start from b
2.compare if a[i]>b[j]
 if it is true swap them.
 else break the loop. (After this step a will have all the small elements than all the elements of b)
3. sort a and b to get the final answer
Time Complexity o(min(n,m) + nlogn + mlogm)
Space complexity O(1)

 */
