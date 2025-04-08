class Solution {
    public TreeNode insertIntoBST(TreeNode root, int value) {
        if(root==null){
            root = new TreeNode(value);
            return root;
        }
        if(root.val>value)root.left=insertIntoBST(root.left,value);
        else root.right=insertIntoBST(root.right,value);
        return root;
    }
}