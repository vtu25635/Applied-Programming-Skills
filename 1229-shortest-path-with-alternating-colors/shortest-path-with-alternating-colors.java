class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] adj = new ArrayList[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) adj[i][j] = new ArrayList<>();
        }
        
        for (int[] edge : redEdges) adj[0][edge[0]].add(edge[1]);
        for (int[] edge : blueEdges) adj[1][edge[0]].add(edge[1]);

        int[][] dist = new int[2][n];
        for (int[] d : dist) Arrays.fill(d, -1);

        Queue<int[]> queue = new LinkedList<>();
        // {node, last_color} -> 0 for red, 1 for blue
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        dist[0][0] = 0;
        dist[1][0] = 0;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];
                int nextColor = 1 - color;

                for (int neighbor : adj[nextColor][node]) {
                    if (dist[nextColor][neighbor] == -1) {
                        dist[nextColor][neighbor] = steps;
                        queue.offer(new int[]{neighbor, nextColor});
                    }
                }
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int rDist = dist[0][i];
            int bDist = dist[1][i];
            if (rDist == -1 || bDist == -1) result[i] = Math.max(rDist, bDist);
            else result[i] = Math.min(rDist, bDist);
        }
        return result;
    }
}