// TC->O(n) , SC->O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/
class Pair{
    TreeNode node;
    int vertical;
    Pair(TreeNode node, int vertical){
        this.node = node;
        this.vertical = vertical;
    }
}
class Solution {
    public List<Integer> topView(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int vertical = p.vertical;
            TreeNode nd =  p.node;
            if(!map.containsKey(vertical)){
                map.put(vertical, nd.data);
            }
            if(nd.left!=null){
                q.add(new Pair(nd.left,vertical-1));
            }
            if(nd.right!=null){
                q.add(new Pair(nd.right,vertical+1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }   
}