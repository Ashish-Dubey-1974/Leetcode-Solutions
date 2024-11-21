class Solution {
    public int rob(int[] num) {
        int n=num.length;
        int[] dp = new int[num.length];
        Arrays.fill(dp,-1);
        return find(0,num,dp);
        // if(num==null||n==0)return 0;
        // if(n==1)return num[0];
        // if(n==2)return Math.max(num[0],num[1]);
        // int[] dp = new int[n];
        // dp[0]=num[0];
        // dp[1] = Math.max(num[1],num[0]);
        // for(int i=2;i<n;i++)dp[i]=Math.max(num[i]+dp[i-2],dp[i-1]);
        // return dp[n-1];
    }
    static int find(int i,int[] nums,int[] dp){
        if(i>=nums.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int rob = nums[i]+find(i+2,nums,dp);
        int drob = find(i+1,nums,dp);
        dp[i]=Integer.max(rob,drob);
        return dp[i];
    } 
}