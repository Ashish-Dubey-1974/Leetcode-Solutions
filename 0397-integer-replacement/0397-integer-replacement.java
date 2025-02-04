class Solution {
    public int integerReplacement(int n) {
        int ans=0;
        if(n<2147483647){
        while(n!=1){
            if(n%2==0){
                n/=2;
                ans++;
            }else{
                if(((n-1)/2)%2==0||((n-1)/2)==1){
                    n=(n-1)/2;
                }else{
                    n=(n+1)/2;
                }ans+=2;
            }
        }return ans;
        }else{
        while(n>Math.pow(2,ans++));
        if(n%2==0)return ans-1;
        return ans;
        }
    }
}