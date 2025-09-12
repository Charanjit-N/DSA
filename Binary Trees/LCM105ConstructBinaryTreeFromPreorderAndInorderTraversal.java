// TC->O(N), SC->O(N)
class Solution {
    TreeNode solve(int[] preorder, int preStart , int preEnd, int[] inorder, int inStart, int inEnd,Map<Integer, Integer> inMap){
        if(preStart>preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int leftSide = inRoot - inStart;
        root.left = solve(preorder, preStart+1,preStart+leftSide,inorder,inStart, inRoot-1,inMap);
        root.right = solve(preorder, preStart+leftSide+1,preEnd,inorder,inRoot+1,inEnd,inMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap= new HashMap<>();
        for(int i =0 ;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = solve(preorder, 0 ,preorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
        
    }
}