class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b)->Integer.compare(b.getValue(),a.getValue()));
        q.addAll(map.entrySet());
        int idx=0;
        while(k>0){
            ans[idx++]=q.poll().getKey();
            k--;
        }return ans;
        
    }
}