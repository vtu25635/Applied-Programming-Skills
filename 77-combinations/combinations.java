import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // Base Case: If the combination is the right size
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Optimization: i <= n - (k - tempList.size()) + 1
        // This ensures we only loop if there are enough numbers left to fill k slots
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            // Move to the next number
            backtrack(result, tempList, i + 1, n, k);
            // Backtrack
            tempList.remove(tempList.size() - 1);
        }
    }
}