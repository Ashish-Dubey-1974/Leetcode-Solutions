class Solution {
    public int minAddToMakeValid(String s) {
        while(s.contains("()")){
            int idx = s.indexOf("()");
            s=s.substring(0,idx)+s.substring(idx+2);
        }
        return s.length();
    }
}