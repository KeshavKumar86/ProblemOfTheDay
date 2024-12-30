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
            for (int j = i + 1; j < n; j++) {
                int key = (arr[i] + arr[j]);
                if (map.containsKey(key)) {
                    List<Integer> value = map.get(key);
                    value.add(i);
                    value.add(j);
                    map.put(key, value);
                } else {
                    list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put((arr[i] + arr[j]), list);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(-arr[i])) {
                List<Integer> value = map.get(-arr[i]);
                for (int j = 0; j < value.size(); j = j + 2) {
                    if (i != value.get(j) && i != value.get(j + 1)) {
                        list = new ArrayList<>();
                        list.add(value.get(j));
                        list.add(value.get(j + 1));
                        list.add(i);
                        Collections.sort(list);
                        result.add(list);
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
Intuition - Instead of storing the single element in the map, and checking the sum(arr[i],arr[j])
in the map, what we will do is reverse of it. We will store the sum(arr[i],arr[j]) as key and (i,j)
as value in the map.This will take 2 iterations, basically sum of all possible pairs(pairSum).
Now we will iterate through the array and check if -arr[i] is present in the map, if it is present
than we can add this in the resulted set.
Time Complexity: O(n^2)
Space complexity: O(n^3) (no. of triplets possible in worst case)

 */