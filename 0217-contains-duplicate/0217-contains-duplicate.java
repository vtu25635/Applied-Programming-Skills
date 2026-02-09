class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Use a HashSet to track seen numbers
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                // if add() returns false, num was already in the set
                return true;
            }
        }
        return false;
    }
}