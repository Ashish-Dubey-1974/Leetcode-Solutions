class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n==0)return "";
        String s = strs[0];
        int i = s.length()-1;
        int idx=1;
        while(idx<n){
            if(strs[idx].startsWith(s))idx++;
            else s = s.substring(0,i--);
            if(s==null)return "";
        }
        return s;
        
    }
}