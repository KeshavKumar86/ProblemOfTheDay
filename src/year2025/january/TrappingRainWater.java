package year2025.january;

public class TrappingRainWater {
    public static void main(String[] args) {

        //arr[] = [3, 0, 1, 0, 4, 0 2]
        int[] arr = new int[]{3, 0, 2, 0, 4};
        System.out.println("Result: " + maxWaterOptimal(arr));

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

    private static int maxWaterOptimal(int[] arr) {

        int maxLeft = 0, maxRight = 0;
        int left = 0, right = arr.length - 1;
        int sum = 0;
        while (left <= right) {
            maxLeft = Math.max(maxLeft, arr[left]);
            maxRight = Math.max(maxRight, arr[right]);
            if (maxLeft < maxRight) {
                sum += maxLeft - arr[left];
                left++;
            } else {
                sum += maxRight - arr[right];
                right--;
            }
        }
        return sum;
    }
}
/*
Solution1: Brute Force Solution
Intuition: The basic intuition of the problem is as follows:

An element of the array can store water if there are higher bars on the left and the right.
The amount of water to be stored in every position can be found by finding the heights of the higher
bars on the left and right sides.
The total amount of water stored is the summation of the water stored in each index.
No water can be filled if there is no boundary on both sides.
So for every index we have to find the maximum element left to it and maximum element right to it,
then total number of water stored at that index will be min(max(left),max(right)-height(index), and
than total sum will be summation of every index.
Time Complexity: O(n^2)
Space complexity: O(1)

Solution2: Improved Solution
In this improvement what we do is instead of calculation max(left) and max(right) at every index we
store the max(left) for every index in an array maxLeft.- O(n) time and O(n) space
same we do for max(right) - O(n) time and O(n) space
Then we iterate every index and find min(max(left),max(right)) - arr[i] and take sum for every index.
Time Complexity: O(n)
Space complexity: O(n)

Solution3: Optimal Solution
Intuition: In this we are storing max(left) and max(right) for every index, then we are taking min of
those. How we can reduce space.
What we do is we take 2 pointer left and right and maxLeft(max before left index from 0) and maxRight(
max after right index till end) now we compare the maxLeft and maxRight and we move only the minimum
one (we need only minimum to get the limit of the water can be stored at index i).

How does this work?
Let us consider the case when left max is less than the right max. For arr[left], we know left max for
it and we also know that the right max for it would not be less than left max because we already
have a greater value in arr[right...n-1]. So for the current bar, we can find the amount of water by
finding the difference between the current bar and the left max bar.
Time Complexity: O(n)
Space complexity: O(1)

Solution4: [Alternate Approach] Using Stack - O(n) Time and O(n) Space
We will see it when we learn stack.
 */