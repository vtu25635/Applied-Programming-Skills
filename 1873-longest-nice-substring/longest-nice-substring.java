import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the partner (opposite case) is missing, split here
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) {
                continue;
            }
            
            // Recurse on the two halves
            String s1 = longestNiceSubstring(s.substring(0, i));
            String s2 = longestNiceSubstring(s.substring(i + 1));
            
            // Return the longer one (or the earlier one if tied)
            return s1.length() >= s2.length() ? s1 : s2;
        }
        
        return s;
    }
}