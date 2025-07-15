// TC->O(logN * log N) , SC->O(logN): height
class Solution {
    int findLeftHeight(TreeNode node){
        int h = 0;
        while(node.left != null){
            h++;
            node =  node.left;
        }
        return h;
    }
    int findRightHeight(TreeNode node){
        int h = 0;
        while(node.right != null){
            h++;
            node =  node.right;
        }
        return h;
    }
    int solve(TreeNode node){
        if(node == null) return 0;
        int lh =  findLeftHeight(node);
        int rh = findRightHeight(node);
        if(lh == rh) return (1<<(lh+1)) - 1;
        else return 1 + solve(node.left) + solve(node.right);
    }
    public int countNodes(TreeNode root) {
        return solve(root); 
    }
}