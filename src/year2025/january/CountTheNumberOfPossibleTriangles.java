package year2025.january;

import java.util.Arrays;

public class CountTheNumberOfPossibleTriangles {
    public static void main(String[] args) {

        //arr[] = [4, 6, 3, 7]
        int[] arr = new int[]{9, 22, 15, 33, 34, 47, 7, 42, 10};
        countTriangles(arr);
        System.out.println("Result: " + countTriangles(arr));
    }

    static int countTriangles(int[] arr) {

        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for (int k = n - 1; k > 1; k--) {
            int j = k - 1;
            int i = 0;
            while (i < j) {
                int sum = arr[i] + arr[j];
                if (sum <= arr[k]) {
                    i++;
                } else {
                    count += (j - i);
                    j--;
                }
            }

        }
        return count;
    }
}
/*
Solution1: Brute Force Solution
We can form a triangle with sides  a,b,c if
a+b>c and b+c>a and c+a>b.
if we sort the array and take the sum of 2 smallest element, and if it is > third element, then we do
not need to check other 2 conditions.
1.Sort the Array
Iterate the array as  i=0, j=i+1,k=j+1 and if arr[i]+arr[j]>arr[k] that means we can form the triangle
so increase the count by 1.
Time complexity: O(n^3)
Space complexity: O(1)

Solution2: Better Solution (Using Binary search for third element)
Take 2 pointers and iterate using 2 loops
and to find third element use binary search.
Time Complexity: O(n^2logn)
Space Complexity: O(1)

Solution3: Optimal Solution
Intuition: Using 2 pointer
1.we will take k as last element and iterate towards 0
take i = 0 and j = k-1 and check if
if(arr[i]+arr[j]<=k)
move i to the right
if(arr[i]+arr[j]>k)
count += (j-i) - all elements to the right also satisfy the condition, so we can directly calculate it.
move j to the left.

Time Complexity: O(n^2)
Space Complexity: O(1)
 */