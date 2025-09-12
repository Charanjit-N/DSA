//TC->O(N) , SC->O(N)
class Pair{
    TreeNode nd;
    int num;
    Pair(TreeNode nd , int num){
        this.nd = nd;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0 ;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last =0;
            for(int i=0;i<size;i++){
                int curId = q.peek().num - min;
                TreeNode node =  q.peek().nd;
                q.poll();
                if(i==0) first = curId;
                if(i==size-1) last = curId;
                if(node.left != null){
                    q.add(new Pair(node.left, 2*curId+1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right , 2*curId+2));
                }
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
        
    }
}