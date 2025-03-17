class GFG_MinimumElementInBST {
   
    //TC->O(Log N), SC->O(1)

    int minValue(Node root) {
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
}

// Using Recursion
class GFG_MinimumElementInBST {

    int minValue(Node root) {
        if(root.left == null) return root.data;
        return minValue(root.left);
    
    }
}