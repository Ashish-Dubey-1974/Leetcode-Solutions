class Solution {
    class pair{
        int prev;
        int curr;
        pair(){}
    }
    public int[] closestPrimes(int left, int right) {
        pair p = new pair();
        int prev=0;
        int curr=0;
        for(int i=left;i<=right;i++){
            if(isprime(i)){
                if(prev==0){prev=i;p.prev=i;}
                else if(curr==0){curr=i;p.curr=i;}
                else{
                    prev = curr;
                    curr = i;
                    if(curr-prev<p.curr-p.prev){
                        p.prev=prev;
                        p.curr=curr;
                    }
                }
            }
        }if(p.prev==0||p.curr==0)return new int[]{-1,-1};
        return new int[]{p.prev,p.curr};
    }

    boolean isprime(int n){ 
        if(n<=1)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }return true;
    }
}