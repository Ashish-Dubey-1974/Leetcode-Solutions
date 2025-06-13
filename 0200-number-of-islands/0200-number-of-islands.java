class Solution {
    class pair{
        int r;
        int c;
        pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans=0;
        int[] row = {0,0,1,-1};
        int[] col = {1,-1,0,0};
        Stack<pair> st = new Stack<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    
                    grid[i][j]='*';
                    ans++;
                    // System.out.print(ans+" ");
                    st.push(new pair(i,j));
                    while(!st.isEmpty()){
                        pair p = st.pop();
                        for(int x=0;x<4;x++){
                            int r = p.r+row[x];
                            int c = p.c+col[x];
                            if(r>=0&&r<n&&c>=0&&c<m&&grid[r][c]=='1'){
                                grid[r][c]='*';
                                st.push(new pair(r,c));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}