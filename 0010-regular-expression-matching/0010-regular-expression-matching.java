class Solution {
    Boolean[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    private boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) return memo[i][j];
        if (j == pattern.length()) return memo[i][j] = (i == text.length());

        boolean firstMatch = (i < text.length() &&
                              (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            memo[i][j] = dp(i, j + 2, text, pattern) || (firstMatch && dp(i + 1, j, text, pattern));
        } else {
            memo[i][j] = firstMatch && dp(i + 1, j + 1, text, pattern);
        }
        return memo[i][j];
    }
}
