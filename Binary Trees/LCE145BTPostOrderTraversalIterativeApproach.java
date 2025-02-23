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

//Using two stacks :  TC->O(2N) , SC->O(2N)
class LCE145BTPostOrderTraversalIterativeApproach {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        TreeNode nd = root;
        s1.push(nd);
        while(!s1.isEmpty()){
            nd = s1.pop();
            s2.push(nd.val);
            if(nd.left!=null) s1.push(nd.left);
            if(nd.right!=null) s1.push(nd.right);
        }
        while(!s2.isEmpty()){
            ls.add(s2.pop());
        }

        return ls;
    }
}


// Space Optimization - Using only one Stack
// TC-> O(2N) , SC->O(N)

class LCE145BTPostOrderTraversalIterativeApproach {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp == null){  
                    temp = st.peek();
                    st.pop();
                    ls.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.peek();
                        st.pop();
                        ls.add(temp.val);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
        return ls;

    }
}