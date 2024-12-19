class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int c1 = 1;
        int c2 = -1;
        int[] colored = new int[m]; // 0 = not colored, 1 = c1, -1 = c2
        boolean[] vis = new boolean[m]; // Tracks visited nodes
        Queue<Integer> q = new LinkedList<>();

        // Handle all components of the graph
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
                        // If the neighbor is already colored and conflicts, return false
                        if (colored[neighbor] == currentColor) return false;

                        // If the neighbor is not visited, color it and add to the queue
                        if (!vis[neighbor]) {
                            colored[neighbor] = oppositeColor;
                            vis[neighbor] = true;
                            q.add(neighbor);
                        }
                    }
                }
            }
        }
        return true; // If no conflicts are found, the graph is bipartite
    }
}
