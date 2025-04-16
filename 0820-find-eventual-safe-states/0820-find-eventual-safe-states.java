class Solution {
    boolean[] vis;
    boolean[] pvis;
    boolean[] safe;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n=graph.length;
        vis = new boolean[n];
        pvis = new boolean[n];
        safe = new boolean[n];

        for(int i=0;i<n;i++){
            dfs(i,graph);
        }

        for(int i=0;i<n;i++){
            if(safe[i])ans.add(i);
        }
        return ans;
    }

    boolean dfs(int node,int[][] g){
        if(vis[node])return safe[node];
        vis[node]=true;
        pvis[node]=true;
        for(int i=0;i<g[node].length;i++){
            if(pvis[g[node][i]])return safe[g[node][i]];
            if(!dfs(g[node][i],g))return false;
        }
        pvis[node]=false;
        safe[node]=true;
        return true;
    }
}                                                 