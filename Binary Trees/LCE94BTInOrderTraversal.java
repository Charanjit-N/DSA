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
class LCE94BTInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans;
    }
    void inOrder(TreeNode node, List<Integer> ls){
        if(node == null) return;
        inOrder(node.left,ls);
        ls.add(node.val);
        inOrder(node.right,ls);
    }
}