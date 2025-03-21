class Solution {
    public int getSum(int a, int b) {
        int xor = a^b;
        int and = a&b;
       if(and==0)return xor;
       else return getSum(xor,and<<1);
    }
}