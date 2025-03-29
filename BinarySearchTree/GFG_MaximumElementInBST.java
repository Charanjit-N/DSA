class GFG_MaximumElementInBST {
   
    //TC->O(Log N), SC->O(1)
    int maxValue(Node root) {
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }

}

// Using Recursion
class GFG_MaximumElementInBST {

    int minValue(Node root) {
        if(root.right == null) return root.val;
        return minValue(root.right);
    
    }
}