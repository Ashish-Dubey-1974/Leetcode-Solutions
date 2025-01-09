class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < ast.length; i++) {
            boolean destroyed = false;
            while (!st.isEmpty() && st.peek() > 0 && ast[i] < 0) {
                int top = st.peek();
                if (Math.abs(top) < Math.abs(ast[i])) {
                    st.pop();
                } else if (Math.abs(top) == Math.abs(ast[i])) {
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                st.push(ast[i]);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
