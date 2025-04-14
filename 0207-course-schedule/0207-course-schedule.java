class Solution {
    public boolean canFinish(int nC, int[][] pr) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> topoOrder = new ArrayList<>();
        for(int i=0;i<nC;i++)graph.add(new ArrayList<>());

        for(int[] i : pr){
            graph.get(i[0]).add(i[1]);
        }

        int[] inDegree = new int[nC];
        for(int i=0;i<graph.size();i++){
            for(int j:graph.get(i))inDegree[j]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<inDegree.length;i++)if(inDegree[i]==0)q.add(i);

        while(!q.isEmpty()){
            int p = q.remove();
            topoOrder.add(p);
            for(int i : graph.get(p)){
                inDegree[i]--;
                if(inDegree[i]==0)q.add(i);
            }
        }
        System.out.print(topoOrder);
        return topoOrder.size()==nC;
    }
}