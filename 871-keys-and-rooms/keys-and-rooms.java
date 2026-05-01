class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Start with room 0
        visited[0] = true;
        queue.offer(0);
        int count = 1;

        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();

            // Check all keys found in the current room
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                    count++;
                }
            }
        }

        // If we visited every room, count should equal n
        return count == n;
    }
}