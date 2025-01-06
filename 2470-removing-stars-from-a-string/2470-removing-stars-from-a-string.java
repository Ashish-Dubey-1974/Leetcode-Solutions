class Solution {
    public String removeStars(String s) {
        Stack<Character> st  = new Stack<>();
        for(char c:s.toCharArray()){
            if(c!='*')st.push(c);
            else if(st.isEmpty())return "";
            else st.pop();
        }
        if(st.isEmpty())return "";
        char[] ch = new char[st.size()];
        int idx=0;
        while(!st.isEmpty())ch[idx++]=st.pop();
        String ans="";
        for(int i=ch.length-1;i>=0;i--)ans+=ch[i];
        return ans;
    }
}