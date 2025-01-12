package year2025.january;

public class TrappingRainWater {
    public static void main(String[] args) {

        //arr[] = [3, 0, 1, 0, 4, 0 2]
        int[] arr = new int[]{2, 1, 5, 3, 1, 0, 4};
        System.out.println("Result: " + maxWater(arr));

    }

    private static int maxWater(int[] arr) {

        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = 0;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i - 1]);
            maxLeft[i] = max;
        }
        max = 0;
        maxRight[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, arr[i + 1]);
            maxRight[i] = max;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - arr[i];
            if (water > 0) {
                sum += water;
            }
        }
        return sum;
    }
}
