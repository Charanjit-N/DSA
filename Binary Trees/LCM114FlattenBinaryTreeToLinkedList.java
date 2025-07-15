// TC->O(N) , SC->O(N)

class Solution {
    TreeNode prev = null;
    void solve(TreeNode node) {
       if(node == null) return;
       flatten(node.right);
       flatten(node.left);
       node.right = prev;
       node.left  = null;
       prev = node;
       
    }
    public void flatten(TreeNode root) {
       solve(root);
    }
}

//TC->O(N) , SC->O(N)
class Solution {
    public void flatten(TreeNode root) {
       Stack<TreeNode> st = new Stack<>();
       if(root == null) return;
       st.push(root);
       while(!st.isEmpty()){
        TreeNode cur =  st.peek();
        st.pop();
        if(cur.right != null)  st.push(cur.right);
        if(cur.left != null) st.push(cur.left);
        if(!st.isEmpty()) cur.right =  st.peek();
        cur.left = null;
       }
    }
}

//TC->O(N), SC->O(1)
class Solution {
    public void flatten(TreeNode root) {
       TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}