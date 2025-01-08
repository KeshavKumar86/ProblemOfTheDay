package year2025.january;

import java.util.Arrays;

public class CountTheNumberOfPossibleTriangles {
    public static void main(String[] args) {

        //arr[] = [4, 6, 3, 7]
        int[] arr = new int[]{9, 22, 15, 33, 34, 47, 7, 42, 10};
        countTriangles(arr);
        System.out.println("Result: " + countTriangles(arr));
    }

    static int countTriangles(int[] arr) {

        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr[i] + arr[j]) > arr[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
