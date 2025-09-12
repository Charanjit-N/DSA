// TC -> O(N) , SC->O(N)  N-> # nodes in BT.
class LCE543DiameterOfBinaryTree{
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        findDiameter(root, diameter);
        return diameter[0];
    }
    int findDiameter(TreeNode node, int[] diameter){
        if(node == null) return 0;

        int leftHeight = findDiameter(node.left, diameter);
        int rightHeight = findDiameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    
}

// Taking a global variable for ans
// TC -> O(N^2) , SC->O(N)  N-> # nodes in BT.
class LCE543DiameterOfBinaryTree {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int LH = findHeight(root.left);
        int RH = findHeight(root.right);

        diameter = Math.max(diameter, LH + RH);

        int Left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        return diameter;
    }
    int findHeight(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = findHeight(node.left);
        
        int rightHeight = findHeight(node.right);

        return 1+ Math.max(leftHeight, rightHeight);
    }
    
}