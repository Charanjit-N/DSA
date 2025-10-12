// TC -> O(n)  , SC->O(log n) n : # nides in tree
class Solution {
    void solve(TreeNode nd, int[] sum){
        if(nd == null) return;
        if(nd.left == null && nd.right==null) return;
        if(nd.left!=null && nd.left.left == null && nd.left.right==null){
            sum[0]+=nd.left.val;
        }
        solve(nd.left , sum);
        solve(nd.right, sum);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum =  new int[1];
        solve(root, sum);
        return sum[0];
        
    }
}