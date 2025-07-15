import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left =  null;
        this.right = null;
    }
}
class ChangeBinaryTreeToSatisfyChildrenSumProperty{
    static void printTree(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size =  q.size();
            for(int i=0;i<size;i++){
                TreeNode nd = q.poll();
                System.out.print(nd.val +" ");
                if(nd.left != null) q.add(nd.left);
                if(nd.right != null) q.add(nd.right);
            }
        }
        System.out.println();
    }

    static void changeTree(TreeNode nd){
        if(nd == null) return;
        int child = 0;
        if(nd.left != null) child += nd.left.val;
        if(nd.right != null) child += nd.right.val;
        
        if(child >=  nd.val) nd.val = child;
        else{
            if(nd.left != null) nd.left.val = nd.val;
            if(nd.right != null) nd.right.val = nd.val;
        }
        changeTree(nd.left);
        changeTree(nd.right);

        int sum  = 0;
        if(nd.left != null) sum +=  nd.left.val;
        if(nd.right != null) sum+= nd.right.val;
        if(nd.left!=null || nd.right != null) nd.val = sum;

    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right= new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        printTree(root);

        changeTree(root);

        printTree(root);

    }
}