package year2025.january;

import java.util.*;

public class CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {

        //arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
        int[] arr = new int[]{1, 1, 1, 1, 1};
        int k = 3;
        System.out.println("Result: " + countDistinct(arr, k));
    }

    private static ArrayList<Integer> countDistinct(int[] arr, int k) {

        int n = arr.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (map.get(arr[i - k]) == 1) {
                    map.remove(arr[i - k]);
                } else {
                    map.put(arr[i - k], map.get(arr[i - k]) - 1);
                }
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (i >= k - 1) {
                arrayList.add(map.size());
            }
        }
        return arrayList;
    }
}
/*
Solution2: Optimal Solution
Intuition: we here we have to count number of windows, so we can use sliding window technique.But to
count distinct element in constant time we have to use hash.We cannot use set because in set we cannot
have the frequency of elements which can leads to wrong results.
We will put the elements in the map with their frequency.
when we move to next window we have to remove the first element of the window, and we have to add new
element in the iteration.
We cannot directly remove the element. we will check the frequency of the element to be removed, if it
is 1 we will remove the elements but if it is greater than 1 we will reduce it by 1.
Time Complexity: O(n)
Space Complexity: O(k)
 */