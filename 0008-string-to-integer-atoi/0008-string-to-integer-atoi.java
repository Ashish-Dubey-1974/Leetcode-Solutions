class Solution {
    public int myAtoi(String s) {
        //if(s.equals("-2147483649"))return -2147483648;
        int op=1;
        boolean flag=false;
        int sign=1;
        long num=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isdigit(ch)){
                flag =true;
                if (sign == 1 && num > (Integer.MAX_VALUE - (ch - '0')) / 10) {
                    return Integer.MAX_VALUE;
                } else if (sign == -1 && -num < (Integer.MIN_VALUE + (ch - '0')) / 10) {
                    return Integer.MIN_VALUE;
                } num=num*10+ch-'0';
            }else if(!flag){
                if(ch==' ')continue;
                flag=true;
                if(ch=='-')sign=-1;
                else if(ch=='+')continue;
                else break;
            }else break;
        }return (int)num*sign;
    }
    public boolean isdigit(int num){
        num=num-'0';
        if(num>=0&&num<=9)return true;
        return false;
    }
}