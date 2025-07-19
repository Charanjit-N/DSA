// TC->O(N), SC->O(N) : recursion stack space
class NodeValue{
    public int minNode, maxNode, maxSize;
    NodeValue(int minNode, int maxNode, int maxSize){
        this.minNode = minNode;
        this.maxNode= maxNode;
        this.maxSize = maxSize;
    }
}
class TUFLargestBSTInBinaryTree {
        NodeValue solve(TreeNode node){
            if(node == null){
                return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }
            NodeValue left =  solve(node.left);
            NodeValue right = solve(node.right);
            if(node.data > left.maxNode && node.data < right.minNode){
                return new NodeValue(Math.min(node.data, left.minNode),Math.max(node.data, right.maxNode), 1 + left.maxSize + right.maxSize);
            }
            else{
                return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
            }
        }
        public int largestBST(TreeNode root) {
            return solve(root).maxSize;
        }
}