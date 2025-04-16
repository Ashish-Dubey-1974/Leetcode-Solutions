class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("",0,n*2);
        return ans;
    }
    void generate(String s,int len,int n){
        if(len==n){
            if(valid(s))ans.add(s);
            return;
        }
        generate(s+"(",1+len,n);
        generate(s+")",1+len,n);
    }
    boolean valid(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')st.push(s.charAt(i));
            else{
                if(st.isEmpty()||st.pop()!='(')return false;
            }
        }
        return st.isEmpty();
    }

}