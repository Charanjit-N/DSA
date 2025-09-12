// Brute : TC-> O(N * height) , SC->O(height)
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

// Optimizec : TC->O(N), SC->O(height)
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


// GFG : Asked to finf (A.val - B.val) not mod where A is ancestor of B
class Solution {
    void dfs(Node TreeNode, int maxAncestor, int[] ans) {
        if (node == null) return;
        ans[0] = Math.max(ans[0], maxAncestor - node.data);
        maxAncestor = Math.max(maxAncestor, node.data);
        dfs(node.left, maxAncestor, ans);
        dfs(node.right, maxAncestor, ans);
    }

    public int maxDiff(TreeNode root) {
        if (root == null) return 0;
        int[] ans = new int[]{Integer.MIN_VALUE};

        if(root.left != null ) dfs(root.left, root.data, ans);
        if(root.right != null) dfs(root.right, root.data,ans);

        return ans[0];
    }
}