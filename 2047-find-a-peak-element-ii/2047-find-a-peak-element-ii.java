class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] ro = {0,0,1,-1};
        int[] co = {1,-1,0,0};
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                for(int x=0;x<4;x++){
                    int r=i+ro[x];
                    int c=j+co[x];

                    if(r>=0&&c>=0&&r<mat.length&&c<mat[i].length&&mat[i][j]<mat[r][c])break;
                    if(x==3)return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}