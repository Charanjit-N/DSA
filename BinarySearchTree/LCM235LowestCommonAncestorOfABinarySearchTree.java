// TC->O(N) , SC->O(N) ; n: # nodes in BT
class Solution {
    TreeNode solve(TreeNode nd, TreeNode p, TreeNode q){
        if(nd == null || nd == p || nd ==q) return nd;
        TreeNode left = solve(nd.left,p,q);
        TreeNode right = solve(nd.right,p,q);
        if(left==null) return right;
        else if(right == null) return left;
        else return nd;  //left != null && right != null
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p,q);       
    }
}


// TC->O(Height : logN) , SC->O(Height) : recursion stack space
class Solution {
    TreeNode solve(TreeNode nd, TreeNode p, TreeNode q){
        if(nd == null ) return null;
        if(p.val < nd.val && q.val < nd.val){
            return solve(nd.left,p,q);
        }
        if(p.val > nd.val && q.val > nd.val){
            return solve(nd.right,p,q);
        }
        return nd;  // p , q lie on either side of node nd
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p,q);       
    }
}


// Iterative code no recursion stack space
// TC ->O(Height : logN), SC->o(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode nd =  root;
        while(nd != null){
            if(p.val < nd.val && q.val < nd.val){
               nd = nd.left;
            }
            else if(p.val > nd.val && q.val > nd.val){
                nd = nd.right;
            }
            else{
                return nd;  // p , q lie on either side of node nd
            } 
        }
        return null;       
    }
}