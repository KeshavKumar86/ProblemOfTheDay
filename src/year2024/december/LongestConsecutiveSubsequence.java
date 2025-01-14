package year2024.december;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {

        //arr[] = [2, 6, 1, 9, 4, 5, 3]
        int[] arr = new int[]{99, 80, 60, 33, 44, 86, 34, 64, 77, 18, 39, 3, 27,
                16, 29, 60, 67, 23, 7, 87, 6, 75, 92, 11, 59, 13, 88, 24, 98, 4, 26, 6};
        int result = longestConsecutiveII(arr);
        System.out.println("Result: " + result);
    }

    private static int longestConsecutive(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 1;
        for (int j : arr) {
            if (map.containsKey(j - 1)) {
                map.put(j, map.get(j - 1) + 1);
                maxLength = Math.max(maxLength, map.get(j - 1) + 1);
                int key = j;
                while (map.containsKey(key + 1)) {
                    map.put((key + 1), map.get(key) + 1);
                    maxLength = Math.max(maxLength, map.get(key) + 1);
                    key++;
                }
            } else if (map.containsKey(j + 1)) {
                map.put(j, 1);
                int key = j;
                while (map.containsKey(key + 1)) {
                    map.put(key + 1, map.get(key) + 1);
                    maxLength = Math.max(maxLength, map.get(key) + 1);
                    key++;
                }
            } else {
                map.put(j, 1);
            }
        }
        return maxLength;
    }

    private static int longestConsecutiveII(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for (int element : arr) {
            set.add(element);
        }
        int maxCount = 0;
        for (int element : set) {
            if (!set.contains(element - 1)) {
                int count = 1;
                while (set.contains(element + 1)) {
                    count++;
                    element++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
/*
Solution1: Using Sorting
1.Sort the array
2.count the consecutive elements, use one variable maxLength to check if this consecutive sequence
has max length than the known maximum.
Time complexity: O(nlogn)
Space complexity: O(1)

Solution2: Optimal Solution using 1 iteration
Intuition: Use a hashmap to store the number and the consecutive sequence till this number,
if map.contains(arr[i] -1) than for arr[i] sequence length will be length(arr[i]-1)+1, and we have to
also update the sequence length for numbers arr[i]+ if they are present.
if(map.contains(arr[i] +1 ) than we have to update the length of all sequence by 1 for values arr[i]++
Time Complexity: O(n)
Space complexity: O(n)

Solution3: Optimal Solution using 2 iteration (very Simple Solution)
Intuition: put every element in the set to reduce the same element and then iterate the set and check
if the number is starting point of the sequence, if it is than check for elements+1 to it and count
the longest length.
Time Complexity: O(n)
Space complexity: O(n)
*/