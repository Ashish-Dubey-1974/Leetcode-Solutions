class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <2) return s;
        int start = 0;
        int end = 0;
        
        for(int i=0;i<s.length();i++){
            int len=center(s,i,i);
            int len2=center(s,i,i+1);
            len = Math.max(len,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }return s.substring(start,end+1);
    }
    int center(String s,int l,int r){
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }return r-l-1;
    }
}