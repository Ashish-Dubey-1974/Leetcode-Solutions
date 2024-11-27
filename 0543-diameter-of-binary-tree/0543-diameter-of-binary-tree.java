
class Solution {
    int d=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return d;
    }
    int diameter(TreeNode root){
        if(root==null)return 0;
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        d=Math.max(d,lh+rh);
        return Math.max(lh,rh)+1;
    }
}