import java.util.*;
//Definition for a binary tree node.
  class TreeNode {
      int data;
      TreeNode left;
    TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
  }
 

// TC->O(N), SC->O(Height)
class Solution {
    void solve(TreeNode node,List<Integer> ls, List<List<Integer>> ans){
        if(node==null) return;
        if(node.left == null && node.right==null){
            ls.add(node.data);
            ans.add(new ArrayList<>(ls));
            ls.remove(ls.size()-1);
            return;
        }
        ls.add(node.data);     
        solve(node.left,ls,ans);
        solve(node.right,ls,ans);
        ls.remove(ls.size()-1);

    }
    List<List<Integer>> allRootToLeaf(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
        solve(root, new ArrayList<>(),ans);
        return ans;
    }
   
}