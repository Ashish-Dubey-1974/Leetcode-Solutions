class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int ans=0;
        HashMap<List<Integer>,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            List<Integer> ls = new ArrayList<>();
            for(int j=0;j<n;j++){
                ls.add(grid[i][j]);
            }map.put(ls,map.getOrDefault(ls,0)+1);
        }
        for(int j=0;j<n;j++){
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<n;i++){
                ls.add(grid[i][j]);
            }if(map.containsKey(ls))ans+=map.get(ls);
        }
        return ans;
    }
}