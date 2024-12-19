package year2024.december;

public class KthMissingPositiveNumberInASortedArray {
    public static void main(String[] args) {

        int[] arr = {3, 5, 9, 10, 11, 12};
        int k = 2;
        System.out.println("Result: " + kthMissing(arr, k));

    }

    private static int kthMissing(int[] arr, int k) {

        for (int element : arr) {
            if (element <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
/*
Solution1: Brute force solution
Intuition:
 */