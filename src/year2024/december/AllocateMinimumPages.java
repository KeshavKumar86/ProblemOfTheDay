package year2024.december;

public class AllocateMinimumPages {
    public static void main(String[] args) {

        int[] arr = {22, 23, 67};
        int k = 1;
        System.out.println("Result: " + findPages(arr, k));

    }

    private static int findPages(int[] arr, int k) {

        int low = max(arr);
        int high = sum(arr);
        if (k > arr.length)
            return -1;
        /*for (int pages = low; pages <= high; pages++) {
            int count = minStudent(arr, pages);
            if (count <= k) {
                return pages;
            }
        }*/
        //Binary search
        while (low <= high) {
            int pages = (low + high) / 2;
            int minStudent = minStudent(arr, pages);
            if (minStudent > k) {
                low = pages + 1;
            } else {
                high = pages - 1;
            }
        }
        return high + 1;
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
/*
Solution1: Naive Solution: using linear search
Intuition: we have to minimize the maximum number of pages we can allocate to a student given the
condition that: every student should get at least one book.
every book should be allocated
To minimize the number of pages, assign the books to the maximum student(initially equal to no of
books).
Now we cannot assign the books to more than k students. so we have to decrease the student.
To decrease the students, we have to increase the number of pages, and we have to keep the number of
pages as minimum as possible, given the condition that we cannot assign the books to more than k
students.
So we will start with the minimum number of pages possible and check if we can meet the condition that
number of students<k, if we cannot, we will increase the no of pages by 1.
we keep doing it until we reach either the no of student<k or
maximum no of pages possible.
Best Case: when we have no of students equal to number of books.In this case minimum no of pages
possible equal to max(arr)
Worst Case: when we have 1 student, so he will get all books, so minimum number of pages possible
equal to sum(arr).
To find the number of students that will be allocated books for a page limit, we start assigning
books to the first student until the page limit is reached, then we move to the next student and
so on. As soon as we find the first page limit with which we can allocate books to all k students,
we will return it.
Time complexity: O((sum-max)*n)
Space complexity: O(1)

Solution2: optimal Solution: using binary search
Time complexity: O(log(sum-max)*n)
Space complexity: O(1)
 */