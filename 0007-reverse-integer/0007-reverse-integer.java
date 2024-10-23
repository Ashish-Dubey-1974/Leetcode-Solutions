class Solution {
    public int reverse(int x) {
       long result = 0;
       while (x != 0) {
            int num = x % 10;
            result = result * 10 + num;
            if (result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE) return 0;
            x /= 10;
        }return (int)result;  
    }}