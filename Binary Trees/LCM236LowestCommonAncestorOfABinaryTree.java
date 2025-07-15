/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// TC->O(N) , SC->O(N) ; n: # nodes in BT
class Solution {
    TreeNode solve(TreeNode nd, TreeNode p, TreeNode q){
        if(nd == null || nd == p || nd ==q) return nd;
        TreeNode left = solve(nd.left,p,q);
        TreeNode right = solve(nd.right,p,q);
        if(left==null) return right;
        else if(right == null) return left;
        else return nd;  //left != null && right != null
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p,q);       
    }
}

