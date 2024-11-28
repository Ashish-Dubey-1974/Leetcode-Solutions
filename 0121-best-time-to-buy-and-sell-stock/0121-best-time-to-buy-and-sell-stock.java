class Solution {
    public int maxProfit(int[] p) {
        int sum=0,minp = p[0];
        for(int j=1;j<p.length;j++){if(minp>p[j])minp=p[j];else{int com = p[j]-minp;sum = com>sum?com:sum;}}
        if(sum>0)return sum;
        return 0;
    }
}