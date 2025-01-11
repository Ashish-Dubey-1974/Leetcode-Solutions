import java.math.BigInteger;
class Solution {
    public String removeDigit(String s, char digit) {
        int idx=0,n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)==digit){
                idx=i;
                if(i<n-1&&digit<s.charAt(i+1))break;
            }
        }return s.substring(0,idx)+s.substring(idx+1);
    }
}