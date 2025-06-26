class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int a = ruby(nums,0,n-1,dp);
        Arrays.fill(dp,-1);
        int b = ruby(nums,1,n,dp);
        return Math.max(a,b);
    }
    int ruby(int[] nums,int idx,int end,int[] dp){
        if(idx>=end)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int rob = nums[idx]+ruby(nums,idx+2,end,dp);
        int skip = ruby(nums,idx+1,end,dp);
        dp[idx] = Math.max(rob,skip);
        return dp[idx];
    }

}