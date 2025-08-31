class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        if(a==b)return (int)((long)a*n%1000000007);
        long lcm = lcm(a,b);
        long low = a<b?a:b;
        long high= (long)(a<b?a:b)*n;
        while(low<high){
            long mid = low+(high-low)/2;
            long count = mid/a+mid/b-mid/lcm;
            if(count<n)low=mid+1;
            else high = mid;
        }
        return (int)(low%1000000007L);
    }
    long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
    long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}