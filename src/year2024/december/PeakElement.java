package year2024.december;

public class PeakElement {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int result = peakElement(arr);
        System.out.println("Result: " + result);
    }

    private static int peakElement(int[] arr) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low - (low - high) / 2;
            if (mid > 0 && arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else if (mid > 0) {
                high = mid - 1;
            } else {
                if (mid+1<arr.length && arr[mid] < arr[mid + 1]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return high;
    }
}
/*
Solution1: naive Solution
Use linear search and check if arr[i-1]<arr[i]>arr[i+1] then arr[i] is the peak element
if i==0 then if arr[i]>arr[i+1] then also arr[i] is the peak element
if i=length-1 then if arr[i]>arr[i-1] then also arr[i] is the peak element
Time Complexity: O(n)
Space complexity: O(1)

Solution2: using linear search
If we observe carefully, we can say that:
If an element is smaller than it's next element then it is guaranteed that at least one peak element
will exist on the right side of this element.
Conversely, if an element is smaller than it's previous element then it is guaranteed that at least
one peak element will exist on the left side of this element.
Therefore, we can use binary search to find the peak element.
if mid == 0 then we will compare with arr[mid+1] and if arr[mid]>arr[mid+1] then arr[mid] is the peak.
but we also have to check if arr[mid+1]<length
Time Complexity: O(logn)
Space complexity: O(1)
 */