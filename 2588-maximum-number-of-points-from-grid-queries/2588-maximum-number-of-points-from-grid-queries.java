import java.util.*;

class Solution {
    class Pair {
        int r, c, val;
        Pair(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length;
        int[] res = new int[queries.length];
        int[] dir = {1, 0, -1, 0, 1}; 
        
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        boolean[][] vis = new boolean[rows][cols];
        minHeap.offer(new Pair(0, 0, grid[0][0]));
        vis[0][0] = true;

        int count = 0;
        int queryIndex = 0;

        while (queryIndex < queries.length) {
            int queryValue = sortedQueries[queryIndex][0];

            while (!minHeap.isEmpty() && minHeap.peek().val < queryValue) {
                Pair p = minHeap.poll();
                count++;

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dir[d], nc = p.c + dir[d + 1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !vis[nr][nc]) {
                        minHeap.offer(new Pair(nr, nc, grid[nr][nc]));
                        vis[nr][nc] = true;
                    }
                }
            }
            res[sortedQueries[queryIndex][1]] = count;
            queryIndex++;
        }

        return res;
    }
}
