class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        sub(nums,0,ls);
        return ans;
    }
    void sub(int[] nums,int idx,List<Integer> ls){
        if(idx==nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[idx]);
        sub(nums,idx+1,ls);
        ls.remove(ls.size()-1);
        sub(nums,idx+1,ls);
    }
}