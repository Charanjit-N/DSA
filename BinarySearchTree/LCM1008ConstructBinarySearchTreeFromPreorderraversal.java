// TC->O(N)  + O(NlogN): sorting for getting inorder, SC->O(N)
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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = new int[n];
        for(int i =0;i<n;i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        Map<Integer, Integer> inMap= new HashMap<>();
        for(int i =0 ;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = solve(preorder, 0 ,preorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
    }
}



// TC-> O(3N)=O(N), SC->O(N) : recursion stack space
class Solution {
     TreeNode solve(int[] preorder, int bound, int[] i){
        if(i[0] ==  preorder.length || preorder[i[0]] > bound ) return null;
        TreeNode root = new TreeNode(preorder[i[0]]);
        i[0]++;
        root.left = solve(preorder, root.val,i);
        root.right = solve(preorder, bound, i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        TreeNode root  = solve(preorder,Integer.MAX_VALUE,new int[]{0});
        return root;
    }
}


        



        
