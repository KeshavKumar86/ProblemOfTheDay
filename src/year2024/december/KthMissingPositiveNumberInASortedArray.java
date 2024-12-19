package year2024.december;

public class KthMissingPositiveNumberInASortedArray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int k = 2;
        System.out.println("Result: " + kthMissing(arr, k));

    }

    private static int kthMissing(int[] arr, int k) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missingNumber = arr[mid] - (mid + 1);
            if (missingNumber < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < 0)
            return k;
        return arr[high] + (k - (arr[high] - (high + 1)));
    }
}
/*
Solution1: Brute force solution
Intuition: if you have to calculate let's say 5th missing number and if any number less than 5 is
present than missing number will increase by 1.
if let's say input is 6 7 8 9, and we have to find first missing number than it will be 1
second missing number = 2
third missing number = 3 and so on
but if input is 3,6,7,8,9
first missing number = 1
second missing number = 2
third missing number = because 3 is present it will increase by 1, so it will be 4.
Time complexity = O(n)
Space complexity = O(1)

Solution 2: optimal solution using binary search
Intuition: if let say every number is present
1 2 3 4 5
than at 0 index element will be 1
than at 1 index element will be 1+1
than at 2 index element will be 2+1 and so on.
at index i element should be (i+1)
but let us say any number is missing than
1 2 4 5 6
let us say we have to calculate at index 2, how many numbers are missing
at index 2 element should be (2+1) but it is 4 now that means (arr[2]-(i+1)) = 4-3 = 1;
now we will apply binary search for low = 0 and high = n and calculate mid
if missing number at index mid<k we will move right
else we will move left, finally we will come out when low>high
than we have to calculate missing numbers at index high.
m = arr[high]-(high+1)
than answer = arr[high] + (k-m)
Time complexity = O(logn)
Space complexity = O(1)

 */