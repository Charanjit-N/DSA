import java.util.*;

/* Definition for a binary tree node.
class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { 
        this.data = val; 
        this.left = null; 
        this.right = null;
     }
}
*/

// TC->O(Height)+O(N)+O(Height)=O(N), SC->O(N)
class Solution {
    boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null) return true;
        return false;
    }
    void leftBoundary(TreeNode root, List<Integer> ans){
        TreeNode nd = root.left;
        while(nd != null){
            if(isLeaf(nd)== false) ans.add(nd.data);
            if(nd.left != null)  nd = nd.left;
            else nd =  nd.right;
        }
    }
    void leafNodes(TreeNode root, List<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left != null) leafNodes(root.left, ans);
        if(root.right != null) leafNodes(root.right, ans);

    }
    void rightBoundary(TreeNode root, List<Integer> ans){
        TreeNode nd = root.right;
        List<Integer> ls = new ArrayList<>();
        while(nd != null){
            if(isLeaf(nd)== false) ls.add(nd.data);
            if(nd.right != null)  nd = nd.right;
            else nd =  nd.left;
        }
        for(int i = ls.size()-1;i>=0;i--){
            ans.add(ls.get(i));
        }
    }
    public List<Integer> boundary(TreeNode root) {
        //your code goes here
        List<Integer> ans =  new ArrayList<>();
        if(!isLeaf(root)) ans.add(root.data);
        leftBoundary(root,ans);
        leafNodes(root,ans);
        rightBoundary(root,ans);
        return ans;
    }
}