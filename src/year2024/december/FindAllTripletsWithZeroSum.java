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

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == 0) {
                        list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        list.add(k);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
/*
Solution1: Brute Force Solution
Check all possible triplets and check which are the triplet's sum equal to zero, and add them into
the result;
Time complexity: O(n*n*n)
Space complexity: O(1)
 */