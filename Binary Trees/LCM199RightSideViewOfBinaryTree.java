// Right Side Veiw of BT : using Recursive Traversal
// TC->O(N) , SC->O(N)
class Solution {
    void solve(TreeNode nd, int level, List<Integer> ans){
        if(nd==null) return;
        if(level == ans.size()) ans.add(nd.val);
        solve(nd.right, level+1,ans);
        solve(nd.left, level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        solve(root, 0, ans);
        return ans;
        
    }
}

// Right Side View of BT : Using level Order Traversal
// TC->O(N) , SC->O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode nd = q.poll();
                if(i==size-1) ans.add(nd.val);
                if(nd.left != null) q.add(nd.left);
                if(nd.right != null) q.add(nd.right);
            }
        }
        return ans;
    }
}

