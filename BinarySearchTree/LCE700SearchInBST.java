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
class LCE700SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {

        // Iteractive way : TC->O(height) = O(log N), SC->O(1), 
        // N-> # nodes in BST
        while(root!=null && root.val != val){
            if(val < root.val) root = root.left;
            else root = root.right;
        }
        return root;

        // recursive way : TC->O(log N), SC->O(log N)
        if(root == null || root.val == val) return root;
        if(val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}