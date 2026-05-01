class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) {
            searchPaths(root, "", answer);
        }
        return answer;
    }

    private void searchPaths(TreeNode node, String path, List<String> answer) {
        
        if (path.length() > 0) {
            path += "->";
        }
        path += node.val;

       
        if (node.left == null && node.right == null) {
            answer.add(path);
            return;
        }

        
        if (node.left != null) {
            searchPaths(node.left, path, answer);
        }
        if (node.right != null) {
            searchPaths(node.right, path, answer);
        }
    }
}