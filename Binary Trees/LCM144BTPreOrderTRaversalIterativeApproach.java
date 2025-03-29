/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// TC-> O(N), SC->(N)  {N-> # nodes in Binary Tree}
class LCM144BTPreOrderTraversalIterativeApproach {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
       if(root == null) return ans;
       Stack<TreeNode> st = new Stack<>();
       
       st.push(root);
       while(!st.isEmpty()){
        TreeNode node = st.pop();
        ans.add(node.val);
        if(node.right!=null){
            st.push(node.right);
        }
        if(node.left!=null){
            st.push(node.left); 
        }
       }
       return ans;
    }
}