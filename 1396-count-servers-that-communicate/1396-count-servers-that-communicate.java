class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int ans=0;
        int n = grid[0].length;
        int[] rwCnt = new int[m];
        int[] clCnt = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){rwCnt[i]++;clCnt[j]++;}
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&(rwCnt[i]>1||clCnt[j]>1))ans++;
            }
        }
        


        return ans;
    }
}