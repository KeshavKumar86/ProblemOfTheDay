package year2024.Days160BonusProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayInThreeEqualSumSubarrays {
    public static void main(String[] args) {

        //arr[] = [1, 3, 4, 0, 4]
        int[] arr = {1, 3, 4, 0, 4};
        List<Integer> result = findSplit(arr);
        System.out.println("Result: " + result);
    }

    private static List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        List<Integer> list = new ArrayList<>();

        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            list.add(-1);
            list.add(-1);
            return list;
        }
        int targetSum = sum / 3;
        int commulativeSum = 0;
        boolean possible = false;
        for (int i = 0; i < arr.length; i++) {
            if ((commulativeSum + arr[i]) < targetSum) {
                commulativeSum += arr[i];
            } else if ((commulativeSum + arr[i]) == targetSum) {
                list.add(i);
                if (list.size() == 2) {
                    possible = true;
                    break;
                }
                commulativeSum = 0;
            }
        }
        if (possible) {
            return list;
        }
        list.clear();
        list.add(-1);
        list.add(-1);
        return list;
    }
}
