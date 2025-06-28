class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int[] row : dp)Arrays.fill(row,-1);
        return helper(triangle,m,1,0,0,dp);
    }
    int helper(List<List<Integer>> g,int m,int n,int r,int c,int[][] dp){
        if(r==m-1)return g.get(r).get(c);
        if(r>=m || c>=n)return 0;
        if(dp[r][c]!=-1)return dp[r][c];
        int d = g.get(r).get(c)+helper(g,m,n+1,r+1,c,dp);
        int ri = g.get(r).get(c)+helper(g,m,n+1,r+1,c+1,dp);
        return dp[r][c] = Math.min(d,ri);
    }
}