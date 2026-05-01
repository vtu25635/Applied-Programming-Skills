class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int INF = m + n; // Maximum possible distance

        // First pass: check top and left
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] != 0) {
                    int top = (r > 0) ? mat[r - 1][c] : INF;
                    int left = (c > 0) ? mat[r][c - 1] : INF;
                    mat[r][c] = Math.min(top, left) + 1;
                }
            }
        }

        // Second pass: check bottom and right
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] != 0) {
                    int bottom = (r < m - 1) ? mat[r + 1][c] : INF;
                    int right = (c < n - 1) ? mat[r][c + 1] : INF;
                    mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
                }
            }
        }

        return mat;
    }
}