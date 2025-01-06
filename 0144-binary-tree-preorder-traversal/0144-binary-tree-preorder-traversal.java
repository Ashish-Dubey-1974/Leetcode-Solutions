// class Solution {
//     List<Integer> list = new ArrayList<>();
//     public List<Integer> preorderTraversal(TreeNode root) {
//         if(root==null)return list;
//         list.add(root.val);
//         preorderTraversal(root.left);
//         preorderTraversal(root.right);
//         return list;
//     }
// }


class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        dfs(root,li);
        return li;
    }
    private void dfs(TreeNode root,List<Integer> li){
         if(root==null){
            return ;
        }
        li.add(root.val);
        dfs(root.left,li);
        dfs(root.right,li);
        return;
    }
}











