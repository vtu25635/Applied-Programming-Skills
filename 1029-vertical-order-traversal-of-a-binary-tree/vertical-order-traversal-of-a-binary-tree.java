class Solution {
    
    class NodeInfo {
        int row;
        int col;
        int val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodeList = new ArrayList<>();
        dfs(root, 0, 0, nodeList);

        
        Collections.sort(nodeList, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> result = new ArrayList<>();
        if (nodeList.isEmpty()) return result;

        
        int lastCol = nodeList.get(0).col;
        List<Integer> currentColumn = new ArrayList<>();
        
        for (NodeInfo node : nodeList) {
            if (node.col != lastCol) {
                result.add(currentColumn);
                currentColumn = new ArrayList<>();
                lastCol = node.col;
            }
            currentColumn.add(node.val);
        }
        result.add(currentColumn);

        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<NodeInfo> nodeList) {
        if (root == null) return;
        nodeList.add(new NodeInfo(row, col, root.val));
        dfs(root.left, row + 1, col - 1, nodeList);
        dfs(root.right, row + 1, col + 1, nodeList);
    }
}