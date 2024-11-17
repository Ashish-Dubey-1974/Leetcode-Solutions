class Solution {
    public String reverseWords(String s) {
        StringBuilder st = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            st.append(words[i]);
            if(i!=0){
                st.append(" ");
            }
        }
        return st.toString();
    }
}