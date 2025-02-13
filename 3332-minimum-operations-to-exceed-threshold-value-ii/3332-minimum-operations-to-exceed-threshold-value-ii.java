class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q=new PriorityQueue<>();
        int ans=0;
        for(int i=0;i<nums.length;i++)q.add((long)nums[i]);
        while(!q.isEmpty()&&q.peek()<k){
            long sm=q.remove(),sm2=q.remove();
            q.add(sm*2+sm2);
            ans++;
        }return ans;
    }
}