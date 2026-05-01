import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Max value is amount + 1 because the most coins we could use is 'amount' (all 1s)
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still max, it means the amount cannot be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}