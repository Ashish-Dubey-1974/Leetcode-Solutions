class Solution {
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     if(root==null)return list;

    //     while(root!=null){
    //         list.add(root.val);
    //         if(root.left!=null)root=root.left;
    //         if(root.right!=null)root=root.right;
    //     }
    //     return list;
        //return preorder(root,list);
    //}
    // public List<Integer> preorder(TreeNode node,List<Integer> list){
    //     if(node==null)return list;
    //     list.add(node.val);
    //     preorder(node.left,list);
    //     preorder(node.right,list);
    //     return list;
    // }
//}










public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val); // Visit the root

            // Push right child first so that left child is processed next
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return list;
    }}














