class Solution {
    int max = 0;
    int[] dp ;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0);
    }
    int helper(int[] nums,int idx){
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1)return dp[idx];
        int rob =nums[idx]+helper(nums,idx+2);
        int skip =helper(nums,idx+1);
        dp[idx] = Math.max(rob,skip);
        return dp[idx];
    }
}