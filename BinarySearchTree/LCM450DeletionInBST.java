/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class LCM450DeletionInBST {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;
        if(root.val == key) return performDeletion(root,root);

        TreeNode nd = root;
        while(nd!=null){
            if(nd.val == key) return performDeletion(root,nd);
            if(key < nd.val) nd = nd.left;
            else nd = nd.right;
        }
        return root;
        
    }
    TreeNode performDeletion(TreeNode root, TreeNode nd){
        if(nd.left == null){
            root = transplant(root, nd, nd.right);
        }
        else if(nd.right == null){
            root = transplant(root, nd, nd.left);
        }
        else{
            TreeNode y = findMinimum(nd.right);
            if(findParent(root,y) != nd){
                root = transplant(root, y, y.right);
                y.right = nd.right;   
            }
            root = transplant(root, nd, y);
            y.left = nd.left;
        }
        return root;
    }
    TreeNode transplant(TreeNode root, TreeNode u, TreeNode v){
        TreeNode uP = findParent(root, u);
        // if(v == null) return null;
        // TreeNode vP = findParent(root, v);
        if(uP == null) root = v;
        else if(u == uP.left) uP.left = v;
        else uP.right = v;
        // if(v != null){
        //     vP =  uP;
        // }
        return root;
    }
    TreeNode findParent(TreeNode root, TreeNode x){
        if(x == root) return null;
        TreeNode parent = null;
        TreeNode nd = root;
        while(true){
            parent = nd;
            if(x.val < nd.val) nd = nd.left;
            else nd =  nd.right;

            if(x.val == nd.val){
                break;
            }
        }
        return parent;
    }
    TreeNode findMinimum(TreeNode x){
        while(x.left!=null){
            x = x.left;
        }
        return x;
    }
}


// Other Easy Approach
// TC - >O(log N) , SC->O(1)
class LCM450DeletionInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val ==  key) return perform(root);

        TreeNode nd = root;
        while(nd != null){
            if(key < nd.val){
                if(nd.left != null && nd.left.val == key){
                    nd.left =  perform(nd.left);
                    break;
                }
                else{
                    nd = nd.left;
                }
            }
            else{
                if(nd.right != null && nd.right.val == key){
                    nd.right =  perform(nd.right);
                    break;
                }
                else{
                    nd = nd.right;
                }
            }
        }
        return root;
    }

    TreeNode perform(TreeNode nd){
        if(nd.left == null) return nd.right;
        else if(nd.right == null) return nd.left;
        else{
            TreeNode rightSub = nd.right;
            TreeNode rightMostOnLeftSub  = findMax(nd.left);
            rightMostOnLeftSub.right = rightSub;
            return nd.left;
        }
    }
    TreeNode findMax(TreeNode nd){
        while(nd.right != null){
            nd = nd.right;
        }
        return nd;
    }

}
