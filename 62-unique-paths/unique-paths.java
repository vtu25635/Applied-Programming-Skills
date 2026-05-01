class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 1D DP array initialized to 1
        // There is only 1 way to reach any cell in the first row (all Rights)
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Iterate through each row starting from the second one
        for (int i = 1; i < m; i++) {
            // For each cell, the new value is:
            // itself (value from the row above) + previous element (value from the left)
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}