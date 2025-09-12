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
class Tuple{
    TreeNode node;
    int vertical;
    int level;
    Tuple(TreeNode node, int vertical, int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tp = q.poll();
            TreeNode node = tp.node;
            int vertical = tp.vertical;
            int level = tp.level;
            if(!map.containsKey(vertical)){
                map.put(vertical,new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level,new PriorityQueue<>());
            }
            map.get(vertical).get(level).add(node.val);

            if(node.left != null){
                q.add(new Tuple(node.left,vertical-1,level+1));
            }
            if(node.right != null){
                q.add(new Tuple(node.right,vertical+1,level+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> i : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> j : i.values()){
                while(!j.isEmpty()){
                    ans.get(ans.size()-1).add(j.poll());
                }
            }
        }
        return ans;
        
    }
}