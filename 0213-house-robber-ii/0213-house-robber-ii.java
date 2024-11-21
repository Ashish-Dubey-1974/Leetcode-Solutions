class Solution {
    public int rob(int[] num) {
        int n=num.length;
        if(n==0)return 0;
        if(n==1)return num[0];
        if(n==2)return num[0]>num[1]?num[0]:num[1];
        int[] dp1 = new int[num.length-1];
        int[] dp2 = new int[num.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int d1 = find(0,num,dp1);
        int d2 = find(1,num,dp2);
        return d1>d2?d1:d2;
    }
    static int find(int i,int[] nums,int[] dp){
        if(i>=dp.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int rob = nums[i]+find(i+2,nums,dp);
        int drob = find(i+1,nums,dp);
        dp[i]=Integer.max(rob,drob);
        return dp[i];
    }
}