class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                idx++;
                ans+=idx;
            }else idx=0;
        }return ans;
    }
}