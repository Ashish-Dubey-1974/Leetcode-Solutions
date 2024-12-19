class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int c1 = 1;
        int c2 = -1;
        int[] colored = new int[m]; 
        boolean[] vis = new boolean[m]; 
        Queue<Integer> q = new LinkedList<>();
        for (int start = 0; start < m; start++) {
            if (!vis[start]) {
                q.add(start);
                vis[start] = true;
                colored[start] = c1;

                while (!q.isEmpty()) {
                    int node = q.remove();
                    int currentColor = colored[node];
                    int oppositeColor = (currentColor == c1) ? c2 : c1;

                    for (int neighbor : graph[node]) {
                        if (colored[neighbor] == currentColor) return false;
                        if (!vis[neighbor]) {
                            colored[neighbor] = oppositeColor;
                            vis[neighbor] = true;
                            q.add(neighbor);
                        }
                    }
                }
            }
        }
        return true; 
    }
}
