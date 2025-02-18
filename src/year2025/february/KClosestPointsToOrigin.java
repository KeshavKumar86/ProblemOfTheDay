package year2025.february;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int k) {

        int[][] result = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->b[0]-a[0]);
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int square = x * x + y * y;
            pq.add(new int[]{square, x, y});
            if(pq.size()>k){
                pq.poll();
            }

        }
        for (int i = 0; i < k; i++) {
            int[] element = pq.poll();
            result[i][0] = element[1];
            result[i][1] = element[2];
        }
        return result;
    }
}
/*
Solution1: Naive Approach
Sort the points according to the increasing order of the distance
and then took out first k points and add them into the result
Time Complexity: O(nlogn)
Space Complexity: O(1)

Solution2: optimal Solution
Intuition: We will use the min heap, we will insert the element in the heap if the size of the heap
is less than k, if it is greater than k we will remove the head of the queue.this way we will remove
the top n-k maximum elements and queue will have k the smallest elements.
Time Complexity: O(klogn)
Space Complexity: O(k)
 */