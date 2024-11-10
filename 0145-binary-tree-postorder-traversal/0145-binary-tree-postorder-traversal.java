
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)return list;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode curr = st1.pop();
            st2.push(curr);
            if(curr.left!=null)st1.push(curr.left);
            if(curr.right!=null)st1.push(curr.right);
        }
        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }return list;

    // List<Integer> helper(TreeNode node,List<Integer> ls){
    //     if(node==null)return ls;
    //     helper(node.left,ls);
    //     helper(node.right,ls);
    //     ls.add(node.val);
    //     return ls;
    //}
    }
}