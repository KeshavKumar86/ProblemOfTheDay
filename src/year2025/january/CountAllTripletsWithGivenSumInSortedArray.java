package year2025.january;

public class CountAllTripletsWithGivenSumInSortedArray {
    public static void main(String[] args) {

        //arr[] = [-3, -1, -1, 0, 1, 2], target = -2
        int[] arr = new int[]{10, 10, 10, 10, 10, 10};
        int target = 30;
        System.out.println("Result: " + countTriplets(arr, target));
    }

    private static int countTriplets(int[] arr, int target) {

        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if ((arr[i] + arr[j] + arr[k]) == target) {
                    result++;
                    int temp = j + 1;
                    while (temp < k && arr[temp] == arr[temp - 1]) {
                        result++;
                        temp++;
                    }
                    k--;

                } else if (arr[i] + arr[j] + arr[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
/*
Solution1: Brute Force
generate all triplets and check if the sum is equal to the target, if sum is equal to target than
increase count by 1.
Time complexity: O(n^3)
Space complexity: O(1)

Solution2: Using HashMap
Generate all pair sum and store in the map as keys and their frequencies as values.O(n^2) time
Iterate through the array and check if map contains target-arr[i], if it contains then add its
frequency to the result.
Time complexity: O(n^2)
Space complexity: O(n)

Solution3: optimal Solution
Intuition: because array is sorted we can use 2 pointer approach.
we will iterate the array using 1 loop i.
then we will take j = i+1 and k = n-1 and check if sum of arr[i]+arr[j]+arr[k] is equal to target.
there are 4 cases(4 different test cases)
10 10 10 11 12 15 15 15 15 (target = 25 with only j and k)
10 10 10 11 12 13 14 15 (target = 25 with only j and k)
10 11 12 13 14 15 15 15 15 (target = 25 with only j and k)
10 10 10 10 10 10 (target = 20 with only j and k)
we will only decrease k ( we will handle duplicate j with temp variable and while loop)
                    result++;
                    int temp = j+1;
                    while(temp<k && arr[temp] == arr[temp-1]){
                        result++;
                        temp++;
                    }
                    k--;

if (arr[i] + arr[j] + arr[k])>target
move k to the left.
if (arr[i] + arr[j] + arr[k])<target
move j to the right.

Time complexity: O(n^2)
Space complexity: O(1)
 */