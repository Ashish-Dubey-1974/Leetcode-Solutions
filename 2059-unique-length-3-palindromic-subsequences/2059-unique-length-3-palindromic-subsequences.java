class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int f = -1, l = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ch) {
                    if (f == -1) {
                        f = i; 
                    }
                    l = i; 
                }
            }
            if (f != -1 && l != -1 && l - f > 1) {
                Set<Character> set = new HashSet<>();
                for (int i = f + 1; i < l; i++) {
                    set.add(s.charAt(i));
                }
                count += set.size();
            }
        }

        return count;
    }
}
