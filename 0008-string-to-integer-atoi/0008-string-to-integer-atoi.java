
class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        return (int)helper(s,0,0,1,false);
    }
    long helper(String s,long num,int idx,int sign,boolean flag){
        if(idx>=s.length())return num*sign;
        if(Character.isDigit(s.charAt(idx))){
            flag=true;
            int val = s.charAt(idx)-'0';
            long check = num*10+val;
            if(sign==1&&check>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(sign==-1&&-check<Integer.MIN_VALUE)return Integer.MIN_VALUE;
            num=num*10+val;
        }else if(!flag){
            flag=true;
            if(s.charAt(idx)=='-')sign=-1;
            else if(s.charAt(idx)=='+')sign=1;
            else return num*sign;
        }else return num*sign;
        return helper(s,num,idx+1,sign,flag);
    }
}