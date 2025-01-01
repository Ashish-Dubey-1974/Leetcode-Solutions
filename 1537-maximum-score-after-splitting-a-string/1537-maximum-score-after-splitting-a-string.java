class Solution {
    public int maxScore(String s) {
        int zero = 0, one = 0;
        int res = -1;
        for(int i = 0; i < s.length(); i++) if(s.charAt(i) == '1') one++;
        if(s.charAt(0) == '0') zero++;
        else one = one > 0 ? one - 1: 0;
        for(int i = 1; i < s.length(); i++) {
            res = Math.max(res, one + zero);
            if(s.charAt(i) == '0') zero++;
            else one = one > 0 ? one - 1: 0;
        }
        return res;
    }
}