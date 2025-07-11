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
class LCE144BTPreOrderTraversal{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }
    void preOrder(TreeNode node, List<Integer> ls){
        if(node == null) return;
        ls.add(node.val);
        preOrder(node.left,ls);
        preOrder(node.right,ls);
    }
}