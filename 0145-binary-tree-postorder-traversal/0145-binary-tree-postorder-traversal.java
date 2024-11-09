
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return helper(root,list);
    }
    List<Integer> helper(TreeNode node,List<Integer> ls){
        if(node==null)return ls;
        helper(node.left,ls);
        helper(node.right,ls);
        ls.add(node.val);
        return ls;
    }
}