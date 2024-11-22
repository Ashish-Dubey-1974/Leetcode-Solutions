class Solution {
    public int climbStairs(int n) {
        if(n<=1)return n;
        int prev=1;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int val = prev2+prev;
            prev=prev2;
            prev2=val;
        }return prev2;
        // if(n==0||n==1)return 1;
        // return climbStairs(n-1)+climbStairs(n-2);
    }
}