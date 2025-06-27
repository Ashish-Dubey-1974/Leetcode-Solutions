class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(grid, m, n, 0, 0, dp);
    }

    int helper(int[][] grid, int m, int n, int r, int c, int[][] dp) {
        if (r == m - 1 && c == n - 1) return grid[r][c];
        if (r >= m || c >= n) return Integer.MAX_VALUE;
        if (dp[r][c] != -1) return dp[r][c];

        int down = helper(grid, m, n, r + 1, c, dp);
        int right = helper(grid, m, n, r, c + 1, dp);
        return dp[r][c] = grid[r][c] + Math.min(down, right);
    }
}
