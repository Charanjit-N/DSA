// TC->O(N), SC->O(N) : recursion stack space.
class Solution {
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;
    void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        if(prev!=null && node.val < prev.val){
            if(first == null){
                first = prev;
                middle = node;
            }
            else{
                last = node;
            }
        }
        prev =  node; // marking cur node and prev
        inorder(node.right);
    }
    public void recoverTree(TreeNode root) {
        first = last = middle = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        // swapped nodes are not adjacent
        if(first != null && last != null){
            int temp =  first.val;
            first.val =  last.val;
            last.val =  temp;
        }
        // Swapped nodes are adjacent
        else if(first != null && middle != null){
            int temp =  first.val;
            first.val =  middle.val;
            middle.val =  temp;
        }
    }
}