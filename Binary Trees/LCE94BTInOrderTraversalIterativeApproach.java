// TC-> O(N) , SC->O(N) {N-> # nodes in BT}
class LCE94BTInOrderTraversalIterativeApproach {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node!=null){
                st.push(node);
                node= node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                ls.add(node.val);
                node = node.right;
            }
        }
        return ls;
    }
}