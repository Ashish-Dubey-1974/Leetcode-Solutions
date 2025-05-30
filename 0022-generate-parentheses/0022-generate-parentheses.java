class Solution {
    List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        generate("",0,n,0,0);
        return ans;
    }
    void generate(String s,int len,int n,int o,int c){
        if(len==n*2){
            ans.add(s);
            return;
        }
        if(o<n)generate(s+"(",1+len,n,o+1,c);
        if(o>c)generate(s+")",1+len,n,o,c+1);
    }
    // boolean valid(String s){
    //     Stack<Character> st = new Stack<>();
    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(i)=='(')st.push(s.charAt(i));
    //         else{
    //             if(st.isEmpty()||st.pop()!='(')return false;
    //         }
    //     }
    //     return st.isEmpty();
    // }

}