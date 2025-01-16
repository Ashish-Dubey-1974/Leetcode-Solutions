class Solution {
    public int maxProfit(int[] p) {
        int minp=p[0],profit=0;
        for(int i=1;i<p.length;i++){
            if(minp>p[i])minp=p[i];
            else{
                profit = profit+p[i]-minp;
                if(i<p.length-1)minp = p[i];
            }
        }return profit;
    }
}