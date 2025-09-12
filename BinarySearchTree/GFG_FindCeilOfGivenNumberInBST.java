/*
Given a BST and a number X, find Ceil of X.
Note: Ceil(X) is a number that is either equal to 
X or is immediately greater than X.

If Ceil could not be found, return -1.
 */

class GFG_FindCeilOfGivenNumberInBST {
    //TC -> O(log N), SC->O(1)
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        int ceil = -1;
        while(root!=null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            if(key > root.data){
                
                root = root.right;
            }
            else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}