class Solution {
    public int[] diStringMatch(String s) {
        int I=0,D=s.length();
        int[] res = new int[D+1];
        int idx=0;
        for(char c:s.toCharArray()){
            if(c=='I')res[idx++] = I++;
            else res[idx++] = D--;
        }res[idx]=D;
        return res;
    }
}