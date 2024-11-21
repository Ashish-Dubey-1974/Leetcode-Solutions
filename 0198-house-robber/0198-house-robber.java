class Solution {
    public int rob(int[] num) {
        int n=num.length;
        if(num==null||n==0)return 0;
        if(n==1)return num[0];
        if(n==2)return Math.max(num[0],num[1]);
        int[] dp = new int[n];
        dp[0]=num[0];
        dp[1] = Integer.max(num[1],num[0]);
        for(int i=2;i<n;i++)dp[i]=Math.max(num[i]+dp[i-2],dp[i-1]);
        return dp[n-1];
    }
}