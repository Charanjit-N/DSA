// Brute Force : for each node calculate all possible paths it can make with other N-1 nodes 
//TC -> O(N^2) ,


// Optimal : Backtracking TC-> O(N) , SC->O(height of the tree) <- recursion stack space  worst case O(N) : Skewed tree
class LCH124MaximumPathSumInBT {
    public int maxPathSum(TreeNode root) {
        // int[] sum = new int[1];
        int[] maxSum = new int[1];
        maxSum[0]= root.val;
        findDiameter(root, maxSum);
        return maxSum[0];
    }
    int findDiameter(TreeNode node, int[] maxSum){
        if(node == null) return 0;

        int leftSum = Math.max(0,findDiameter(node.left,  maxSum));
        int rightSum = Math.max(0,findDiameter(node.right,  maxSum));
       
        maxSum[0] = Math.max(maxSum[0], leftSum+rightSum+node.val);

        return node.val +  Math.max(leftSum, rightSum);
    }
}