package year2024.december;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

        int[] arr = {5,4,3,2,1};
        int key = 9;
        int result = search(arr, key);
        System.out.println("Result: " + result);
    }

    static int search(int[] arr, int target) {

        /*int index = findRotationIndex(arr); //O(logn)
        int a = binarySearch(arr, 0, index - 1, key); //O(logn)
        if (a != -1) {
            return a;
        }
        return binarySearch(arr, index, arr.length - 1, key); ////O(logn)*/

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            //check is left half is sorted
            if (arr[left] <= arr[mid]) {
                //because it is sorted than I can check the below condition
                //check is this part has answer
                if (arr[left] <= target && target <= arr[mid]) { //eliminate right
                    right = mid - 1;
                } else {//eliminate left
                    left = mid + 1;
                }
            } else {  // right part is sorted(if left is not sorted, it is guaranteed)
                //because it is sorted than I can check the below condition
                //check is this part has answer
                if (arr[mid] <= target && target <= arr[right]) { //eliminate left half
                    left = mid + 1;
                } else {//eliminate right
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {

        while (left <= right) {
            int mid = left - (left - right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int findRotationIndex(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            if (arr[mid] > arr[arr.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
/*
Solution1: Naive approach
Use linear search
Time complexity: O(n)
Space complexity: O(1)

Solution2: optimal approach (but take 3 iteration of o(logn))
1.Find the rotation index using variation of binary search
2.apply binary search in the first sorted half
3.apply the binary search in the second sorted half
Time Complexity: O(logn)
Space complexity: O(1)

Solution3: Optimal approach (take only one iteration of o(logn))
1.find the mid.
2.As we know that we can apply binary search logic only if array is sorted. when we have rotated the
array we get 2 halves of the array, and any one half will be guaranteed to be sorted, we need to check
which half is sorted so that we can apply binary search logic on that half.
to check is left subarray is sorted
if(arr[mid]>=arr[low]) that means left subarray is sorted.
then
    if(arr[low]<=target && target<=arr[mid]) than target lies in left subarray, so reduce the search
    area to the left subarray (right = mid-1)
    else answer lies in the right subarray, so reduce the search area to the left subarray.
    (left = mid+1)
else (that means right subarray is sorted)
  if(arr[low]<=target && target<=arr[mid]) than target lies in left subarray, so reduce the search
    area to the left subarray (right = mid-1)
    else answer lies in the right subarray, so reduce the search area to the left subarray.
    (left = mid+1)
Time Complexity: O(logn)
Space complexity: O(1)
 */