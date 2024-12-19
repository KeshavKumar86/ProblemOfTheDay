package year2024.december;

public class AllocateMinimumPages {
    public static void main(String[] args) {

        int[] arr = {15, 10, 19, 10, 5, 18, 7};
        int k = 5;
        System.out.println("Result: " + findPages(arr, k));

    }

    private static int findPages(int[] arr, int k) {

        int low = max(arr);
        int high = sum(arr);
        if (k > arr.length)
            return -1;
        for (int pages = low; pages <= high; pages++) {
            int count = minStudent(arr, pages);
            if (count <= k) {
                return pages;
            }
        }
        return -1;
    }

    private static int minStudent(int[] arr, int maxPages) {
        //allocate the books in such a way that no student can hold more than maxPages
        int student = 1;
        int pageCount = 0;
        for (int element : arr) {
            if (pageCount + element <= maxPages) {
                pageCount += element;
            } else {
                student++;
                pageCount = element;
            }
        }
        return student;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return sum;
    }

    private static int max(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
