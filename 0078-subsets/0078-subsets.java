class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int p = (int)Math.pow(2,n);
        for(int i=0;i<p;i++){
            List<Integer> ls = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(((1<<j)&i)!=0)ls.add(nums[j]);
            }ans.add(ls);
        }
        return ans;
    }
    
}