class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp)Arrays.fill(row,-1);
        return count(m,n,0,0,dp);
    }
    int count(int row,int col,int r,int c,int[][] dp){
        if(row-1==r&&col-1==c)return 1;
        if(row<=r || col<=c )return 0;
        if(dp[r][c]!=-1)return dp[r][c];
        int down = count(row,col,r+1,c,dp);
        int left = count(row,col,r,c+1,dp);
        return dp[r][c]=down+left;
    }
}