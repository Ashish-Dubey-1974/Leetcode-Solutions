class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder st = new StringBuilder();
        for(int i=0 ; i<strs[0].length();i++){
            char s=strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(i>= strs[j].length() || strs[j].charAt(i)!=s)
                return st.toString();
            }         
            st.append(s);   
        }
        return st.toString();
    }
}