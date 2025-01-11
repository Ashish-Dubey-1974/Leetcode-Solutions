class Solution {
    public int maxProfit(int[] p) {
        int profit=0,minp=p[0];
        for(int i=1;i<p.length;i++){
            if(minp>p[i])minp = p[i];
            else{
                profit = Math.max(profit,p[i]-minp);
            }
        }return profit;
    }
}