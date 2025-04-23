class Solution {
    boolean[] path;
    boolean[] vis;
    boolean[] safe;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ls = new ArrayList<>();
        int n = graph.length;
        path = new boolean[n];
        vis = new boolean[n];
        safe = new boolean[n];
        for(int i=0;i<n;i++)dfs(i,graph);
        for(int i=0;i<n;i++)if(safe[i])ls.add(i);
        return ls;
    }
    boolean dfs(int node,int[][]g){
        if(vis[node])return safe[node];
        vis[node] = true;
        path[node] = true;
        for(int neigh : g[node]){
            if(path[neigh])return safe[neigh];
            if(!dfs(neigh,g))return false;
        }
        path[node]=false;
        safe[node]=true;
        return true;
    }
}