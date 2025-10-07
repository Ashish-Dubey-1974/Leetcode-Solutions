class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        int[] row = {0,0,1,-1};
        int[] col = {1,-1,0,0};
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int time = arr[0],r = arr[1],c = arr[2];
            if(r==n-1 && c==n-1)return time;
            if(vis[r][c])continue;
            vis[r][c]=true;
            for(int i=0;i<4;i++){
                int nr = r+row[i];
                int nc = c+col[i];
                if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc])
                pq.add(new int[]{Math.max(grid[nr][nc],time),nr,nc});
            }
        }return 0;
    }
}
