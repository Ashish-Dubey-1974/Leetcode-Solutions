class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[][] dp = new int[m][m];

        for(int i=0;i<m;i++)dp[0][i] = matrix[0][i];

        for(int i=1;i<m;i++){
            for(int j=0;j<m;j++){
                int min = dp[i-1][j];
                if(j>0)min = Math.min(dp[i-1][j-1],min);
                if(j<m-1)min = Math.min(dp[i-1][j+1],min);
                dp[i][j] = min+matrix[i][j];
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)ans = Math.min(ans,dp[m-1][i]);
        return ans;       
    }
}