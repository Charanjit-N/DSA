// TC->O(N) , SC->O(N)  where N-> # nodes in BT
class LCE104HeightOrMaxDepthOfBT {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1+ Math.max(leftHeight, rightHeight);
    }
    
}

// TC->O(N) , SC->O(N)  where N-> # nodes in BT
class LCE104HeightOrMaxDepthOfBT {
    public int maxDepth(TreeNode root) {
        return findHeight(root, 0);
    }
    int findHeight(TreeNode node, int cnt){
        if(node == null) return cnt;
        int leftHeight = findHeight(node.left,cnt+1);
        int rightHeight = findHeight(node.right,cnt+1);
        return Math.max(leftHeight, rightHeight);

    }
}