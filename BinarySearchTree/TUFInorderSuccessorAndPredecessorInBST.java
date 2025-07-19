// TC->O(logN), SC->O(1)
class Solution {
    static List<Integer> succPredBST(TreeNode root, int key) {
        TreeNode nd = root;
        TreeNode suc = null;
        while(nd != null){
            if(key >= nd.data) nd =  nd.right;
            else{
                suc = nd;
                nd =  nd.left;
            }
        }
        // suc.data -> successor
        nd = root;
        TreeNode pre = null;
        while(nd != null){
            if(key <= nd.data) nd =  nd.left;
            else{
                pre = nd;
                nd =  nd.right;
            }
        }
        // pre.data -> predecessor 
        List<Integer> ans = new ArrayList<>();
        ans.add(pre != null ? pre.data : -1); // -1 if no predecessor
        ans.add(suc != null ? suc.data : -1); // -1 if no successor
        return ans;
    }
}