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

// TC --> O(n)
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level= 0;
        int maxSumLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            level++;
            int sum = 0;
            int curSize =  q.size();
            for(int i=1;i<=curSize;i++){
                TreeNode nd =  q.poll();
                sum +=  nd.val;
                if(nd.left != null) q.add(nd.left);
                if(nd.right != null) q.add(nd.right);
            }
            if(sum > maxSum){
                maxSum = sum;
                maxSumLevel = level;
            }
        }
        return maxSumLevel;
    }
}