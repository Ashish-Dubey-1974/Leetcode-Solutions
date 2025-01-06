class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            list.add(curr.val);
            if(curr.right!=null)st.push(curr.right);
            if(curr.left!=null)st.push(curr.left);
        }
        return list;
    }
}










// public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         if (root == null) return list;

//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);

//         while (!stack.isEmpty()) {
//             TreeNode node = stack.pop();
//             list.add(node.val); // Visit the root

//             // Push right child first so that left child is processed next
//             if (node.right != null) stack.push(node.right);
//             if (node.left != null) stack.push(node.left);
//         }

//         return list;
//     }}














