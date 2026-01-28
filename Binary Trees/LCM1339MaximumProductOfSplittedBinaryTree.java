class Solution {
    long ans = 0;
    int MOD = (int)1e9 + 7;

    long dfs(TreeNode nd, long totalSum) {
        if (nd == null) return 0;

        long leftSum = dfs(nd.left, totalSum);
        long rightSum = dfs(nd.right, totalSum);

        long subTreeSum = leftSum + rightSum + nd.val;

        long product = subTreeSum * (totalSum - subTreeSum);
        ans = Math.max(ans, product);

        return subTreeSum;
    }
    public int maxProduct(TreeNode root) {
        long totalSum = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode nd = q.poll();
            totalSum += nd.val;
            if (nd.left != null) q.add(nd.left);
            if (nd.right != null) q.add(nd.right);
        }

        dfs(root, totalSum);

        return (int) (ans % MOD);
    }
}

