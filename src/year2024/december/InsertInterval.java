package year2024.december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {

        int[][] arr = new int[5][2];
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{3, 5};
        arr[2] = new int[]{6, 7};
        arr[3] = new int[]{8, 10};
        arr[4] = new int[]{12, 16};
        int[] interval = {13, 20};

        List<int[]> result = insertInterval(arr, interval);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }


    }

    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int index;
        boolean flag = false;
        for (index = 0; index < n; index++) {
            if (intervals[index][0] > newInterval[0]) {
                break;
            }
        }
        ArrayList<int[]> result = new ArrayList<>();
        if (index == 0) {
            result.add(new int[]{newInterval[0], newInterval[1]});
            int count1 = 0;
            for (int[] interval : intervals) {
                if (result.get(count1)[1] < interval[0]) {
                    result.add(interval);
                    count1++;
                } else if (result.get(count1)[1] < interval[1]) {
                    int[] remove = result.remove(count1);
                    result.add(new int[]{remove[0], interval[1]});
                }
            }
        } else {
            result.add(intervals[0]);
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (i == index && !flag) {
                    if (result.get(count)[1] < newInterval[0]) {
                        result.add(newInterval);
                        count++;
                    } else if (result.get(count)[1] < newInterval[1]) {
                        int[] remove = result.remove(count);
                        result.add(new int[]{remove[0], newInterval[1]});
                    }
                    i--;
                    flag = true;
                } else {
                    if (result.get(count)[1] < intervals[i][0]) {
                        result.add(intervals[i]);
                        count++;
                    } else if (result.get(count)[1] < intervals[i][1]) {
                        int[] remove = result.remove(count);
                        result.add(new int[]{remove[0], intervals[i][1]});
                    }
                }

            }
        }
        if (index == n) {

            if (result.get(result.size() - 1)[1] < newInterval[0]) {
                result.add(newInterval);
            } else if (result.get(result.size() - 1)[1] < newInterval[1]) {
                int[] remove = result.remove(result.size() - 1);
                result.add(new int[]{remove[0], newInterval[1]});
            }
        }
        return result;
    }
}

