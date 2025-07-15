// N : # node sin BT ,TC->O(N) , SC->O(N) : recursion stack space
class Solution {
    boolean solve(TreeNode nd1, TreeNode nd2){
        if(nd1== null && nd2==null) return true;
        else if(nd1 == null || nd2 == null) return false;
            
       return  nd1.val == nd2.val && solve(nd1.left, nd2.left) && solve(nd1.right,nd2.right);

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p,q);
    }
}