class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = groupId++;
        }

        List<List<Integer>> itemAdj = new ArrayList<>();
        List<List<Integer>> groupAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) itemAdj.add(new ArrayList<>());
        for (int i = 0; i < groupId; i++) groupAdj.add(new ArrayList<>());

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[groupId];

        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemAdj.get(prev).add(i);
                itemIndegree[i]++;
                if (group[i] != group[prev]) {
                    groupAdj.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        List<Integer> itemOrder = topoSort(itemAdj, itemIndegree, n);
        List<Integer> groupOrder = topoSort(groupAdj, groupIndegree, groupId);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) return new int[0];

        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : itemOrder) {
            groupToItems.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        int[] result = new int[n];
        int idx = 0;
        for (int grp : groupOrder) {
            List<Integer> items = groupToItems.getOrDefault(grp, new ArrayList<>());
            for (int item : items) result[idx++] = item;
        }

        return result;
    }

    private List<Integer> topoSort(List<List<Integer>> adj, int[] indegree, int count) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            for (int next : adj.get(curr)) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }
        return order.size() == count ? order : new ArrayList<>();
    }
}