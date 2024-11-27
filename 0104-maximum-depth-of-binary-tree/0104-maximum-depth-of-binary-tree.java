class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        // int lh = maxDepth(root.left);
        // int rh = maxDepth(root.right);

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}