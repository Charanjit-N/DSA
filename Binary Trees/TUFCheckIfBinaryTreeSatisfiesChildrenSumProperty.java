// TC->O(N),SC->O(N)
class Solution {
    boolean solve(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return true;
        int l = (node.left  != null) ? node.left.val  : 0;
        int r = (node.right != null) ? node.right.val : 0;
        return node.val == l + r && solve(node.left) && solve(node.right);
    }
    boolean checkChildrenSum(TreeNode root) { 
        return solve(root);
    }
}
