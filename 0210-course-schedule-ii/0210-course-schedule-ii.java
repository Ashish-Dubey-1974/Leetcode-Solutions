class Solution {
    public int[] findOrder(int nC, int[][] pr) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] topoOrder = new int[nC];

        for(int i=0;i<nC;i++)graph.add(new ArrayList<>());

        for(int[] i : pr){
            graph.get(i[1]).add(i[0]);
        }

        int[] inDegree = new int[nC];
        for(int i=0;i<graph.size();i++){
            for(int j:graph.get(i))inDegree[j]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<inDegree.length;i++)if(inDegree[i]==0)q.add(i);
        int idx=0;
        while(!q.isEmpty()){
            int p = q.remove();
            topoOrder[idx++]=p;
            for(int i : graph.get(p)){
                inDegree[i]--;
                if(inDegree[i]==0)q.add(i);
            }
        }
        if(topoOrder.length>1)if(topoOrder[nC-1]==0&&topoOrder[nC-2]==0)return new int[]{};
        return topoOrder;
        
    }
}