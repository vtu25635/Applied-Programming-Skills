import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap: store points based on distance (descending)
        // (b[0]^2 + b[1]^2) - (a[0]^2 + a[1]^2)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        for (int[] point : points) {
            maxHeap.add(point);
            // If we have more than k points, remove the one furthest away
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare the final result array
        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }
        
        return result;
    }
}