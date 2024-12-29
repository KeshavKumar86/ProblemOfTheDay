package year2024.december;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArraysWithDuplicateElements {
    public static void main(String[] args) {

        //a[] = [1, 2, 1, 3, 1], b[] = [3, 1, 3, 4, 1]
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{4,5,6};
        ArrayList<Integer> result = intersectionWithDuplicates(a, b);
        System.out.println("Intersection result: " + result);
    }

    private static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int element : a) {
            set1.add(element);
        }
        for (int element : b) {
            set2.add(element);
        }
        //iterate over any set and check if element is present in another set or not
        // if it presents than add it in the result
        for (int element : set1) {
            if (set2.contains(element)) {
                list.add(element);
            }
        }
        return list;
    }
}
/*
Solution1: Brute Force Solution
Iterate the first array and check if element present in the second array, if it is present than add it
in the resulted set.
Time Complexity: O(n*m)
Space complexity: O(n+m)

Solution2: Optimal Solution1
Iterate first array and add the elements in the set1.
Iterate second array and add the elements in the set2.
Iterate set1 and check if element is also present in set2, if it is present than add in the result.
Time complexity: O(n+m)
Space complexity: O(n+m)

Solution3: Optimal Solution2 (little improved)
 */