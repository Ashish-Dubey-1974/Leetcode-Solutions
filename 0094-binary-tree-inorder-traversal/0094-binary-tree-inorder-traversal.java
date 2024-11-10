class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)return list;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr!=null||!st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            list.add(curr.val);
            curr = curr.right;
        }return list;










    //     return helper(root,list);
    // }
    // List<Integer> helper(TreeNode node,List<Integer> ls){
    //     if(node==null)return ls;
    //     helper(node.left,ls);
    //     ls.add(node.val);
    //     return helper(node.right,ls);
    }
}