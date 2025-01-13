package year2025.january;

public class ContainerWithMostWater {
    public static void main(String[] args) {

        //arr[] = [1, 5, 4, 3]
        int[] arr = new int[]{2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println("Result: " + maxWater(arr));
    }

    private static int maxWater(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(arr[left], arr[right]));
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
/*
Solution1: Brute Force
Intuition: Take 2 loops to generate all possible pairs and for all pairs calculate the water using
formula = Math.min(arr[i],arr[j])*(j-i).
for(int i=0;i<n-1;i++){
for(int j=i+1;j<n;j++){
formula = Math.min(arr[i],arr[j])*(j-i)
}}
Time Complexity: O(n^2)
Space Complexity: O(1)

Solution2: Optimal Solution
Intuition: Here we are taking minimum of arr[i] and arr[j] and multiplying the distance between them
to get the answers.Because we are taking minimum, so if arr[i] is minimum then to get the maximum value
we have to take the j which is at maximum distance.
So we will take 2 pointers from both ends of the array. then we will calculate the ans, and then we
will move the minimum element index because we have already calculated the maximum possible answer with
this index. if there are elements greater than arr[right] in between arr[left] and arr[right] that
does not matter.
1 5 4 3
maximum possible answer for arr[left] = min(1,3)*(3-0) = 3. 1 is minimum between 1 and 3 so 1 will get
maximum answer with 3(it is at max distance), even though 5 and 4 are also present after 1.
so we will move left.
Time Complexity: O(n)
Space Complexity: O(1)
 */