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

// TC->O(log N) , SC->O(1)
class LCM701InsertionInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode nd = root;
        if(root == null) return new TreeNode(val);
        while(true){
            if(val > nd.val){
                if(nd.right!=null) nd = nd.right;
                else{
                    nd.right = new TreeNode(val);
                    break;
                }
            }
            else{
                if(nd.left!=null) nd = nd.left;
                else{
                    nd.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}