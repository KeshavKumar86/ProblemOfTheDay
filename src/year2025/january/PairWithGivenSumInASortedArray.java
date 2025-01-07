package year2025.january;

public class PairWithGivenSumInASortedArray {
    public static void main(String[] args) {

        //arr[] = [-1, 1, 5, 5, 7], target = 6
        int[] arr = new int[]{1, 1, 1, 1};
        int target = 2;
        System.out.println("Result: " + countPairs(arr, target));

    }

    private static int countPairs(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int count = 0;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum == target) {
                count++;
                int temp = low + 1;
                while (temp < high && arr[temp - 1] == arr[temp]) {
                    count++;
                    temp++;
                }
                high--;
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return count;
    }
}
/*
Solution1: Brute Force Approach
Iterate all possible pairs and check is sum is equal to target, if it is then increase the
count by 1.
Time Complexity: O(n^2)
Space Complexity: O(1)

Solution2: Better Approach (It can be solved using binary search.)
Time Complexity: O(nlogn)
Space Complexity: O(1)

Solution3: Optimal Solution
Intuition: Because the array is sorted, and we do not have to take care of indexes, we can make use
of 2 pointer technique.
there are 4 cases(4 different test cases)
10 10 10 11 12 15 15 15 15 (target = 25 with only j and k)
10 10 10 11 12 13 14 15 (target = 25 with only j and k)
10 11 12 13 14 15 15 15 15 (target = 25 with only j and k)
10 10 10 10 10 10 (target = 20 with only j and k)
we will only decrease k ( we will handle duplicate j with temp variable and while loop)
if (sum<target) move low to the right
if(sum>target) move high to the left
Time Complexity: O(n)
Space Complexity: O(1)
 */