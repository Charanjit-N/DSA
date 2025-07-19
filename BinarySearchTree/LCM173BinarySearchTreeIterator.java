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
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    void pushAll(TreeNode node){
        while(node != null){
            st.push(node);
            node =  node.left;
        }
    }
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    public int next() {
        TreeNode nd =  st.pop();
        pushAll(nd.right);
        return nd.val;
    }
    public boolean hasNext() {
        return st.isEmpty() ? false : true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */