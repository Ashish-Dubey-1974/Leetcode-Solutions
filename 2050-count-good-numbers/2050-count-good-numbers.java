class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long e=(n+1)/2;
        long o=n-e;
        return (int)((helper(5,e,MOD)*helper(4,o,MOD))%MOD);
    }
    long helper(long b,long e,int mod){
        long ans=1;
        b%=mod;
        while(e>0){
            if((e&1)==1)ans=(ans*b)%mod;
            b=(b*b)%mod;
            e>>=1;
        }return ans;
    }
}