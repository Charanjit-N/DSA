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

// TC -->O(N) , N --> Number Of Nodes
class Solution {
    int maxDepth = 0;
    TreeNode lca = null;
    int dfs(TreeNode nd, int depth){
        maxDepth=Math.max(maxDepth, depth);
        if (nd == null) return depth;
        int l=dfs(nd.left, depth+1);
        int r=dfs(nd.right, depth+1);
        if(l==maxDepth && r==maxDepth){
            lca = nd; 
        }
        return Math.max(l, r); 
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return lca;
    }
}

