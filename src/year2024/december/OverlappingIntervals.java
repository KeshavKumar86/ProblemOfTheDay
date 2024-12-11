package year2024.december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {
    public static void main(String[] args) {

        int[][] arr = new int[4][2];
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{2, 13};
        arr[2] = new int[]{2, 4};
        arr[3] = new int[]{4, 7};

        List<int[]> result = mergeOverlap(arr);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static List<int[]> mergeOverlap(int[][] arr) {

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int n = arr.length;
        result.add(arr[0]);
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (result.get(count)[1] < arr[i][0]) {
                result.add(arr[i]);
                count++;
            }
           else if (result.get(count)[1] < arr[i][1]) {
                int[] remove = result.remove(count);
                result.add(new int[]{remove[0], arr[i][1]});
            }
        }
        return result;
    }
}
