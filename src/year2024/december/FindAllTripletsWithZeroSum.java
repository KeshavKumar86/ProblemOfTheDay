package year2024.december;

import java.util.*;

public class FindAllTripletsWithZeroSum {
    public static void main(String[] args) {

        //arr[] = [0, -1, 2, -3, 1]
        int[] arr = new int[]{0, 1, 1, -2, 1, -2};
        List<List<Integer>> result = findTriplets(arr);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }

    private static List<List<Integer>> findTriplets(int[] arr) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list;
        int n = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> value;
            if (map.containsKey(arr[i])) {
                value = map.get(arr[i]);
            } else {
                value = new ArrayList<>();
            }
            value.add(i);
            map.put(arr[i], value);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = -(arr[i] + arr[j]);
                if (map.containsKey(target)) {
                    List<Integer> value = map.get(target);
                    for (int element : value) {
                        list = new ArrayList<>();
                        if (i != element && j != element) {
                            list.add(i);
                            list.add(j);
                            list.add(element);
                            Collections.sort(list);
                            result.add(list);
                        }

                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
/*
Solution1: Brute Force Solution
Check all possible triplets and check which are the triplet's sum equal to zero, and add them into
the result;
Time complexity: O(n*n*n)
Space complexity: In the worst case, where every combination of three elements forms a valid triplet,
the number of unique triplets can be at most n(n−1)(n−2)/6, which simplifies to O(n^3) for space.

Solution2: Improved Solution
Iterate through the array and store the values as keys in map and indices in the list as values
of map.
Iterate using 2 loops and search the -(sum) in the map and if it is present, iterate through the all
indices of that values and add to the resulted set.
Worst Case: O(n^3), when the map's lists contain a large number of indices for many pairs.
Average Case: Closer to O(n^2)
for most real-world inputs, assuming the map's lists are relatively short.
Space complexity: O(n^3) (no. of triplets possible in worst case)

Solution3: Optimal solution

 */