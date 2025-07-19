// TC->O(N) , SC->O(N): recursion stack space + O(N) : inorder list
class Solution {
    void inorder(TreeNode node, List<Integer> in){
        if(node == null) return;
        inorder(node.left,in);
        in.add(node.val);
        inorder(node.right, in);
    }
    public int kthLargest(TreeNode root, int k) {
        List<Integer> in =  new ArrayList<>();
        inorder(root, in);
        return in.get(n-k);
        
    }
}

// TC->O(N) , SC->O(N) : recursion stack space
class Solution {
    void reverseInorder(TreeNode node, int[] cnt,int k ,int[] ans){
        if(node == null || cnt[0] > k) return;
        reverseInorder(node.right, cnt,k,ans);
        cnt[0]++;
        if(cnt[0] == k) ans[0] = node.val;
        reverseInorder(node.left,cnt,k,ans);
       
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] ans =  new int[1];
        int[] cnt = new int[1];
        reverseInorder(root, cnt,k,ans);
        return ans[0];
    }
}