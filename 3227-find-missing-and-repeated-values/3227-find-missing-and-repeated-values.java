class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[] ans = new int[2];
        boolean[] arr = new boolean[n*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!arr[grid[i][j]-1])arr[grid[i][j]-1]=true;
                else ans[0]=grid[i][j];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(!arr[i])ans[1]=i+1;
        }return ans;
    }
}