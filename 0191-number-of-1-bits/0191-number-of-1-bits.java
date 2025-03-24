class Solution {
    public int hammingWeight(int n) {
       int ans=0;
       int mask=1;
       while(mask<=n&&mask!=0){
        if((mask&n)!=0)ans++;
        mask=mask<<1;
       }
       return ans;
    }
}