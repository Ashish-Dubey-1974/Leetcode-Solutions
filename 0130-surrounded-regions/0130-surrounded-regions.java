class Solution {
    class pair{
        int r;
        int c;
        pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis = new boolean[m][n];
        Stack<pair> st = new Stack<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'&& (i==0||j==0||i==m-1||j==n-1)){
                    st.push(new pair(i,j));
                    vis[i][j]=true;
                }
            }
        }
        while(!st.isEmpty()){
            pair p=st.pop();
            int[]ra={0,0,1,-1};
            int[]ca={1,-1,0,0};
            for(int i=0;i<4;i++){
                int rn = ra[i]+p.r;
                int cn = ca[i]+p.c;
                if(rn>=0&&rn<m&&cn>=0&&cn<n&&board[rn][cn]=='O'&&!vis[rn][cn]){
                    st.add(new pair(rn,cn));
                    vis[rn][cn]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'&& !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }
}