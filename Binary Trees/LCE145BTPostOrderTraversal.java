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

// TC -> O(n) {traversing each node once, n-> no.of nodes} SC->O(n) {Auxiliary stack space for recursion}
class LCE145BTPostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root,ans);
        return ans;
    }
    void postOrder(TreeNode node, List<Integer> ls){
        if(node == null) return;
        postOrder(node.left,ls);
        postOrder(node.right,ls);
        ls.add(node.val);
    }
}