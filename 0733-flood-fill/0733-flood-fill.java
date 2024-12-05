class Solution {
    class pair{
        int row;
        int col;
        pair(int r,int c){
            this.row=r;this.col=c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color==image[sr][sc])return image;
        int n=image.length;
        int m = image[0].length;
        int rc = image[sr][sc];
        int[][] img = new int[n][m];
        int[][] vis = new int[n][m];
        //copy of data not change in real data
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                img[i][j] = image[i][j];
            }
        }
        img[sr][sc] = color;
        Stack<pair> st = new Stack<>();
        int[] colt = {0,0,1,-1};
        int[] rowt = {-1,1,0,0};
        st.add(new pair(sr,sc));
        while(!st.isEmpty()){
            pair p = st.pop();
            for(int i=0;i<4;i++){
                int ct=colt[i]+p.col;
                int rt = rowt[i]+p.row;
                if(rt>=0&&rt<n&&ct>=0&&ct<m&&img[rt][ct]==rc&&vis[rt][ct]==0){
                    st.add(new pair(rt,ct));
                    vis[rt][ct]=1;
                    img[rt][ct] = color;
                }
            }
        }return img;
        
    }
}