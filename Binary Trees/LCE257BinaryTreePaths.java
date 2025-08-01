// TC->O(N), SC->O(Height)
class Solution {
    void solve(TreeNode node, StringBuilder sb, List<String> ans) {
        if (node == null) return;
        int len = sb.length(); 
        if (node.left == null && node.right == null) {
            sb.append(node.val);
            ans.add(sb.toString()); 
            sb.setLength(len); 
            return;
        } 
        sb.append(node.val);
        sb.append("->"); 
        solve(node.left, sb, ans);
        solve(node.right, sb, ans);
        sb.setLength(len); 
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(root, sb, ans);
        return ans;
    }
}
