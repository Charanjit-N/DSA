// TC->O(N) , SC->O(N) : recursion stack space
class Solution {
    boolean solve(TreeNode node, Long left , Long right){
        if(node == null) return true;
        if(node.val <= left || node.val >= right) return false;
        return solve(node.left, left, (long)node.val) && solve(node.right, (long)node.val, right);
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}