class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.length() > 1 || Character.isDigit(token.charAt(0))) {
                st.push(Integer.parseInt(token));
            } else {
                int a = st.pop();
                int b = st.pop();
                if (token.equals("+")) {
                    st.push(b + a);
                } else if (token.equals("-")) {
                    st.push(b - a);
                } else if (token.equals("*")) {
                    st.push(b * a);
                } else if (token.equals("/")) {
                    st.push(b / a);
                }
            }
        }
        return st.peek();
    }
}
