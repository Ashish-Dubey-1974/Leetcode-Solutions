class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1)return 0;
        int[][] dp= new int[m][n];
        for(int[] row:dp)Arrays.fill(row,-1);
        return helper(obstacleGrid,m,n,0,0,dp);
    }
    int helper(int[][] grid,int m,int n,int r,int c,int[][] dp){
        if(r==m-1&&c==n-1)return 1;
        if(r>m-1||c>n-1||grid[r][c]==1)return 0;
        if(dp[r][c]!=-1)return dp[r][c];
        int down = helper(grid,m,n,r+1,c,dp);
        int right = helper(grid,m,n,r,c+1,dp);
        return dp[r][c] = down+right;
    }
}