class Solution {
    public int fib(int n) {
        if(n<=1)return n;
        int prev2=1;
        int prev=0;
        for(int i=2;i<=n;i++){
            int val = prev+prev2;
            prev=prev2;
            prev2=val;
        }return prev2;
    }
}