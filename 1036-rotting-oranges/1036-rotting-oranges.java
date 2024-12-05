class Solution {
   class pair{
        int row,col,tm;
        pair(int r,int c,int t){
            this.row=r;this.col=c;this.tm=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else vis[i][j]=0;
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int tm=0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tm = tm>t?tm:t;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0&& grid[nrow][ncol]==1){
                    q.add(new pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return tm;
    }
}