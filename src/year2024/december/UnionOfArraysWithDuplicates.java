package year2024.december;

import java.util.HashSet;
import java.util.Set;

public class UnionOfArraysWithDuplicates {
    public static void main(String[] args) {

        //a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3]
        int[] a = new int[]{1, 2, 1, 1, 2};
        int[] b = new int[]{2, 2, 1, 2, 1};

        System.out.println("Result: " + findUnion(a, b));

    }

    private static int findUnion(int[] a, int[] b) {

        Set<Integer> set = new HashSet<>();

        for (int element : a) {
            set.add(element);
        }
        for (int element : b) {
            set.add(element);
        }
        return set.size();
    }
}
/*
Solution1: Brute Force Approach
Intuition: iterate through a and check is element is already visited, if it is not visited then
increase count by 1, do the same for b array
Time Complexity: O((n+m)*(n+m))
Space complexity: O(1)

Solution2: By Using Sorting
Intuition: 1.Sort both arrays.
2.Merge the two arrays while counting distinct elements.
Sorting: O(nlogn+mlogm)
Merging: O(n+m)
Overall Time complexity: O(nlogn+mlogm)
Space complexity: O(1)

Solution3: optimal Solution
1.Add the elements of array a into the set
2.Add the elements of array b into the set
return the size of the set.
Time Complexity: O(n+m) on an avg.
Space complexity: O(n+m)
 */