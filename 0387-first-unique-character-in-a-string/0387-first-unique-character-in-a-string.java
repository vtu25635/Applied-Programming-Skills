class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        
        // Build frequency map
        for (int i = 0; i < n; i++) {            
            count[s.charAt(i) - 'a']++;
        }
        
        // Find the index
        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}