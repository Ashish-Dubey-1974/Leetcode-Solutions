class Solution {
    class pair{
        int r;
        int c;
        pair(int r,int c){
            this.r=r;this.c=c;
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int cnt=0;
        int[] ra = {0,0,1,-1};
        int[] ca = {1,-1,0,0};
        boolean[][] vis = new boolean[m][n];
        // dfs
        Stack<pair> st = new Stack<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&!vis[i][j]){
                    vis[i][j]=true;
                    st.push(new pair(i,j));
                    while(!st.isEmpty()){
                        pair p = st.pop();
                        for(int x=0;x<4;x++){
                            int r = ra[x]+p.r;
                            int c = ca[x]+p.c;
                            if(r>=0&&r<m&&c>=0&&c<n&&grid[r][c]=='1'&&!vis[r][c]){
                                vis[r][c]=true;
                                st.push(new pair(r,c));
                            }
                        }
                    }cnt++;
                }
            }
        }return cnt;
    }
}