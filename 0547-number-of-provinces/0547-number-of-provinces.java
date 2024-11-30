class Solution {
    public int findCircleNum(int[][] isCon) {
        int count=0;
        boolean[] vis = new boolean[isCon.length];
        for(int i=0;i<isCon.length;i++){
            if(vis[i]==false){
                dfs(vis,isCon,i);
                count++;
            }
        }return count;
    }
    void dfs(boolean[] vis,int[][] isCon,int idx){
        Stack<Integer> st = new Stack<>();
        st.push(idx);
        vis[idx]=true;
        while(!st.isEmpty()){
            int node = st.pop();
            for(int it=0;it<isCon[idx].length;it++){
                if(isCon[node][it]==1&&vis[it]==false){
                    st.push(it);
                    vis[it]=true;
                }
            }
        }
    }
}