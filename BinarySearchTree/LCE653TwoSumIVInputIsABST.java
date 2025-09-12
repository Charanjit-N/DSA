//TC->O(N)+O(N) , SC->O(N)
class Solution {
    void inorder(TreeNode nd, List<Integer> in){
        if(nd ==  null) return ;
        inorder(nd.left,in);
        in.add(nd.val);
        inorder(nd.right,in);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> in =  new ArrayList<>();
        inorder(root, in);
        int l = 0;
        int r = in.size()-1;
        while(l < r){
            if(in.get(l) + in.get(r) > k) r--;
            else if(in.get(l) + in.get(r) <  k) l++;
            else return true;
        }
        return false;
    }
}

// Using BST iterator next() , before() methods
// TC->O(N) . SC->O(height) + O(height)  stacks for next, before
class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    boolean before = true;
    void pushAll(TreeNode node){
        while(node != null){
            st.push(node);
            if(before ==  true){
                node =  node.right;
            }
            else{
                node =  node.left;
            }
        }
    }
    public BSTIterator(TreeNode root, boolean isBefore) {
        before =  isBefore;
        pushAll(root);
    }
    public int next() {
        TreeNode nd =  st.pop();
        if(before == true) pushAll(nd.left);  
        else pushAll(nd.right);
        return nd.val;
    }
    
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator i = new BSTIterator(root, false);
        BSTIterator j = new BSTIterator(root, true);
        int l = i.next();
        int r = j.next();  // it acts as before()
        while(l<r){
            if(l+r > k ){
                r = j.next();  // before()
            }
            else if(l+r < k){
                l = i.next();
            }
            else return true;
        }
        return false;
    }
}