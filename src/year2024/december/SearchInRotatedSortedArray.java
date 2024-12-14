package year2024.december;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        int result = search(arr, key);
        System.out.println("Result: " + result);
    }

    static int search(int[] arr, int key) {

        int index = findRotationIndex(arr); //O(logn)
        int a = binarySearch(arr, 0, index - 1, key); //O(logn)
        if (a != -1) {
            return a;
        }
        return binarySearch(arr, index, arr.length - 1, key); ////O(logn)
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
