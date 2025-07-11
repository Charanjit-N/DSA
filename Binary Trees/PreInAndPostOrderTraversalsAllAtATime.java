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

// TC-> O(3N), SC->O(N)
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node =  node;
        this.num = num;
    }
}
class Solution {
    public void PreInAndPostOrderTraversalsAllAtATime(TreeNode root) {
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root,1));
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        if(root == null) return postOrder;
        while(!st.isEmpty()){
            Pair x = st.pop();
            
            /* This is part of preorder : increment 1 to 2 and push the left side of the tree into stack */
            if(x.num == 1){
                preOrder.add(x.node.val);
                x.num++;
                st.push(x);

                if(x.node.left!=null){
                    st.push(new Pair(x.node.left,1));
                }
            }

            /* This is part of inorder : increment 2 to 3 and push the right side of the tree into stack */
            else if(x.num == 2){
                inOrder.add(x.node.val);
                x.num++;
                st.push(x);

                if(x.node.right!=null){
                    st.push(new Pair(x.node.right,1));
                }
            }

            // do not push the node back in stack
            else{
                postOrder.add(x.node.val);
            }
        }

        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
       

       
    }
}