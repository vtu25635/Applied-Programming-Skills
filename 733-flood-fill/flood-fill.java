class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];
        
        // If the starting pixel is already the target color, no work is needed
        if (startingColor != color) {
            dfs(image, sr, sc, startingColor, color);
        }
        
        return image;
    }

    private void dfs(int[][] image, int r, int c, int startColor, int newColor) {
        // Base case: check bounds and if the current pixel matches the starting color
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != startColor) {
            return;
        }

        // Update the color
        image[r][c] = newColor;

        // Recurse to 4-directional neighbors
        dfs(image, r + 1, c, startColor, newColor);
        dfs(image, r - 1, c, startColor, newColor);
        dfs(image, r, c + 1, startColor, newColor);
        dfs(image, r, c - 1, startColor, newColor);
    }
}