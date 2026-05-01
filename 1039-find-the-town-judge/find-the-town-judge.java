class Solution {
    public int findJudge(int n, int[][] trust) {
        // We use n + 1 to accommodate 1-based indexing
        int[] trustScores = new int[n + 1];

        for (int[] relationship : trust) {
            int a = relationship[0];
            int b = relationship[1];
            
            // Person 'a' trusts someone, so they can't be the judge
            trustScores[a]--;
            
            // Person 'b' is trusted by someone
            trustScores[b]++;
        }

        for (int i = 1; i <= n; i++) {
            // The judge must be trusted by n-1 people and trust 0 people
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}