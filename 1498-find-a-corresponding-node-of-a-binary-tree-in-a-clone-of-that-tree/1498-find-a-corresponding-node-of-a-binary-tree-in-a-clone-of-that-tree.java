/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
       int num = target.val;
       return find(cloned,num);
    }
    TreeNode find(TreeNode cloned,int value){
        if(cloned == null)return null;
        if(cloned.val == value)return cloned;
        TreeNode leftnode = find(cloned.left,value);
        if(leftnode!=null)return leftnode;
        return find(cloned.right,value);
       
    }
}