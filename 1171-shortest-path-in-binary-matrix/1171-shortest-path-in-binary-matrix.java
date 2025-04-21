class Solution {
    class pair{
        int r;
        int c;
        int d;
        pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] g) {
        int[] dis = new int[g.length];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int n = g.length;
        if(n==1&& g[0][0]==0)return 1;
        boolean[][] vis = new boolean[n][n];
        if(g[0][0]==1||g[n-1][n-1]==1)return -1;
        Queue<pair> q=new LinkedList<>();
        int[] ro = {-1,-1,0,1,1,1,0,-1};
        int[] co = {0,1,1,1,0,-1,-1,-1};
        q.add(new pair(0,0,1));
        vis[0][0]=true;
        while(!q.isEmpty()){
            pair p = q.remove();
            for(int i=0;i<8;i++){
                int r=p.r+ro[i];
                int c=p.c+co[i];
                if(r==n-1&&c==n-1)return p.d+1;
                if(r>=0&&c>=0&&r<n&&c<n&&!vis[r][c]&&g[r][c]!=1){
                    vis[r][c]=true;
                    q.add(new pair(r,c,p.d+1));
                }
            }
        }return -1;

    }
}