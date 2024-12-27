package year2024.december;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {

        //arr[] = [1, 5, 7, -1, 5], target = 6
        int[] arr = new int[]{5, 6, 5, 7, 7, 8};
        int target = 13;
        System.out.println("Result: " + countPairs(arr, target));

    }

    static int countPairs(int[] arr, int target) {

        int result = 0;
        int sameCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : arr) {
            int value = target - element;
            if (value == element) {
                sameCount++;
            } else {
                if (map.containsKey(value)) {
                    int freq = map.get(value);
                    result = result + freq;
                }
                map.put(element, map.getOrDefault(element, 0) + 1);
            }

        }
        return (result + ((sameCount * (sameCount - 1)) / 2));
    }
}
