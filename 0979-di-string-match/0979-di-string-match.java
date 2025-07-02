class Solution {
    public int[] diStringMatch(String s) {
        int I=0,D=s.length(),idx=0;
        int[] res = new int[D+1];
        for(char c:s.toCharArray())res[idx++] = c=='I'?I++:D--;    
        res[idx]=D;
        return res;
    }
}