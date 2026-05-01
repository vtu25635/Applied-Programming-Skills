class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        
        // Start from the 3rd step (index 2)
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        
        // The "top" can be reached from either of the last two steps
        return Math.min(first, second);
    }
}