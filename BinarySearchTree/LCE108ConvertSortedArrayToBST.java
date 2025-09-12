// TC -->O(n), SC->O(log n)

class Solution {

    TreeNode buildBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2; 
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, l, mid - 1);
        root.right = buildBST(nums, mid + 1, r);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    
}