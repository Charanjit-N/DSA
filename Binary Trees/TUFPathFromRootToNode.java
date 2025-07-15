import java.util.*;
//Definition for a binary tree node.
// class TreeNode {
//       int data;
//       TreeNode left;
//       TreeNode right;
//       TreeNode(int val) { data = val; left = null; right = null; }
// }

// TC ->O(N : # nodes in BT) , SC->O(Height)
class Solution {
    boolean findPath(TreeNode node, int nodeVal,List<Integer> ans){
        if(node==null) return false;
        ans.add(node.data);
        if(node.data == nodeVal){
            return true;
        }
        if(findPath(node.left,nodeVal,ans) || findPath(node.right,nodeVal,ans) ){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;

    }
    List<Integer>rootToNode(TreeNode root, int nodeVal) {
        List<Integer> ans = new ArrayList<>();
        findPath(root,nodeVal, ans);
        return ans;
    }
}