class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int half = n / 2;
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean isVowel = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';

            if (isVowel) {
                if (i < half) count++;
                else count--;
            }
        }
        return count == 0;
    }
}
