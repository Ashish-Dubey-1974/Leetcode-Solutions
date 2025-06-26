class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int a = ruby(nums,0,false,dp);
        Arrays.fill(dp,-1);
        int b = ruby(nums,1,true,dp);
        return Math.max(a,b);
    }
    int ruby(int[] nums,int idx,boolean flag,int[] dp){
        if(flag&&idx>=nums.length)return 0;
        if(!flag&&idx>=nums.length-1)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int rob = nums[idx]+ruby(nums,idx+2,flag,dp);
        int skip = ruby(nums,idx+1,flag,dp);
        dp[idx] = Math.max(rob,skip);
        return dp[idx];
    }

}