class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preorder(root,list);
    }
    public List<Integer> preorder(TreeNode node,List<Integer> list){
        if(node==null)return list;
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
        return list;
    }
}