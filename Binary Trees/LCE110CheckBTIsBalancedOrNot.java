//Optimal :  TC- >O(N), SC->O(N)   N-> # nodes in BT
class LCE110CheckBTIsBalancedOrNot {
    public boolean isBalanced(TreeNode root) {
        return findHeight(root) == -1 ? false : true; 
        // return findHeight(root) != -1;
        
    }
    int findHeight(TreeNode node){
        if(node == null) return 0;

        int leftHeight = findHeight(node.left);
        if(leftHeight == -1) return -1;
        int rightHeight = findHeight(node.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight-rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

// TC- >O(N^2), SC->O(N)   N-> # nodes in BT
class LCE110CheckBTIsBalancedOrNot {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int LH = findHeight(root.left);
        int RH = findHeight(root.right);

        if(Math.abs(LH-RH)>1) return false;

        boolean Left = isBalanced(root.left);
        boolean Right = isBalanced(root.right);

        if(Left == false || Right == false) return false;
        return true;
    }

    int findHeight(TreeNode node){
        if(node == null) return 0;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}




