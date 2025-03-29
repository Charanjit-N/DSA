class GFG_FindFloorOfGivenNumberInBST {
    //TC -> O(log N), SC->O(1)
    int findFloor(Node root, int key) {
        if (root == null) return -1;
        int floor = -1;
        while(root!=null){
            if(root.data == key){
                floor = root.data;
                return floor;
            }
            if(key < root.data){
                root = root.left;
            }
            else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}