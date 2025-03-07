class Solution {
    public int[] closestPrimes(int left, int right) {
        int pprev=0;
        int pcurr=0;
        int prev=0;
        int curr=0;
        for(int i=left;i<=right;i++){
            if(isprime(i)){
                if(prev==0){prev=i;pprev=i;}
                else if(curr==0){curr=i;pcurr=i;}
                else{
                    prev = curr;
                    curr = i;
                    if(curr-prev<pcurr-pprev){
                        pprev=prev;
                        pcurr=curr;
                    }
                }
            }
        }if(pprev==0||pcurr==0)return new int[]{-1,-1};
        return new int[]{pprev,pcurr};
    }

    boolean isprime(int n){ 
        if(n<=1)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }return true;
    }
}