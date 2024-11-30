class Solution {
    public int maxDepth(String s) {
        return Depth(s);
    }
    public int Depth(String s){
        int maxDepth=0,currDepth=0;
        for(char c : s.toCharArray()){
            if(c == '('){
                currDepth++;
                maxDepth = Math.max(maxDepth,currDepth);
            }
            if(c == ')')
            currDepth--;
        }
        return maxDepth;
    }
}