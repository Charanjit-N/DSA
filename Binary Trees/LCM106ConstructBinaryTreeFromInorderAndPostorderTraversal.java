// TC->O(N),SC->O(N)
class Solution {
    TreeNode solve(int[] inorder, int inStart, int inEnd,int[] postorder, int postStart , int postEnd, Map<Integer, Integer> inMap){
        if(postStart>postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int leftSide = inRoot - inStart;
        root.left = solve(inorder,inStart, inRoot-1,postorder, postStart,postStart+leftSide-1,inMap);
        root.right = solve(inorder,inRoot+1,inEnd,postorder, postStart+leftSide,postEnd-1,inMap);
        return root;
    }
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        Map<Integer, Integer> inMap= new HashMap<>();
        for(int i =0 ;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = solve(inorder,0,inorder.length-1,postorder,0, postorder.length-1,inMap);
        return root;
    }
}