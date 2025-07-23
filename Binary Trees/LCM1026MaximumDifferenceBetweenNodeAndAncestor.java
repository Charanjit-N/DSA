// TC-> O(N * height) , SC->O(height)
class Solution {
    void dfs(TreeNode node, List<TreeNode> ancest, int[] max){
        if(node == null) return ;
        for(TreeNode x :  ancest){
            max[0] = Math.max(max[0], Math.abs(node.val-x.val));
        }
        ancest.add(node);
        dfs(node.left , ancest, max);
        dfs(node.right,ancest,max);
        ancest.remove(ancest.size()-1);
    }
    public int maxAncestorDiff(TreeNode root) {
        List<TreeNode> ancest = new ArrayList<>();
        int[] max = new int[1];
        dfs(root, ancest, max);
        return max[0];
        
    }
}

// TC->O(N), SC->O(height)
class Solution {
    int dfs(TreeNode node, int maxVal, int minVal){
        if(node == null) return maxVal - minVal ;
        maxVal = Math.max(maxVal, node.val);
        minVal =  Math.min(minVal, node.val);

        int left = dfs(node.left , maxVal,minVal);
        int right  = dfs(node.right,maxVal,minVal);
        return Math.max(left, right);
    }
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, root.val, root.val);
    }
}