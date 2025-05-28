class Solution {
    public double myPow(double x, int n) {
        int nn = 1;
        if(n<0)nn=-1;
        n=Math.abs(n);
        double ans=helper(x,n);
        if(nn==-1)return 1/ans;  
        return ans;      
    }
    double helper(double x,int n){
        if(n==0)return 1;
        if(n%2==0)return helper(x*x,n/2);
        else return x*helper(x*x,n/2);
        
    }
}