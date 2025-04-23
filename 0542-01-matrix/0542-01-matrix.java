class Solution {
    class pair{
        int r;
        int c;
        int d=0;
        pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] M = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new pair(i,j,0));
                    vis[i][j]=true;
            }
        }}
        int[] rn = {0,0,1,-1};
        int[] cn = {1,-1,0,0};
        while(!q.isEmpty()){
            pair p = q.remove();
            for(int i=0;i<4;i++){
                int row=p.r+rn[i];
                int col=p.c+cn[i];
                if(row>=0&&row<n&&col>=0&&col<m&&!vis[row][col]){
                    if(mat[row][col]==1){
                        q.add(new pair(row,col,p.d+1));
                        M[row][col]=p.d+1;
                    }
                    vis[row][col]=true;
                }
            }
        }return M;

    }

}