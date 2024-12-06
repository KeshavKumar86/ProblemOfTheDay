package year2024.december;

import java.util.Arrays;

public class FindHIndex {
    public static void main(String[] args) {

        int[] arr = {1, 3, 4};
        System.out.println("H-Index: " + hIndex(arr));
    }

    private static int hIndex(int[] citations) {

        Arrays.sort(citations);
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            count++;
            if (count == citations[i]) {
                return citations[i];
            }
            if (count > citations[i]) {
                return count - 1;
            }

        }
        return count;
    }
}

