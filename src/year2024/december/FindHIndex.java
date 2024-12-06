package year2024.december;

import java.util.Arrays;

public class FindHIndex {
    public static void main(String[] args) {

        int[] arr = {1, 3, 4};
        System.out.println("H-Index: " + hIndex(arr));
    }

    private static int hIndexCountingSort(int[] citations) {
        int[] freq = new int[1000001];
        for(int i: citations){
            freq[i]++;
        }
        int count=0;
        for(int i=1000000;i>=0;i--)
        {
            count+=freq[i];
            if(count>=i)
                return i;
        }
        return 0;
    }

    private static int hIndex(int[] citations) {

        Arrays.sort(citations);
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            count++;
            if (count == citations[i]) {
                return citations[i];
            }
            if (count > citations[i]) {
                return count - 1;
            }

        }
        return count;
    }
}
/*
First Solution: Naive Solution
1. Naive Approach
Algorithm:
Iterate through all possible values of H (from 0 to the maximum number of citations).
Count how many papers have citations ≥ H.
Check if this count is at least H and track the largest valid H.
Time Complexity:
O(n⋅m), where n is the size of the array and m is the maximum number of citations.

Second Solution: Sorting based
Sort the array and start from end and check at any point count>=arr[i]
Time Complexity: O(nlogn+n)=O(nlogn)
Space complexity: O(1)

Third Solution: Little improved solution(Using counting Sort)
count the frequency of each number that can be present in the array and start from end and
check at any time freq>=arr[i]
Time Complexity: O(n+m)=O(n) where n is the size of the array and m is the maximum number of citations.
Space complexity: O(m) m is the maximum number of citations.

Optimal Solution:
 */
