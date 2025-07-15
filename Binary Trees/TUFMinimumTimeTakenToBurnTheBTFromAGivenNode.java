// TC->O(N), SC->O(N)
class Solution {
    TreeNode markParentsAndReturnStartingNode(TreeNode root, Map<TreeNode, TreeNode> parent, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parent.put(root, null);
        TreeNode startingNode = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode nd =  q.poll();
                if(nd.data == start) startingNode = nd;
                if(nd.left != null){
                    parent.put(nd.left,nd);
                    q.add(nd.left);
                }
                if(nd.right != null){
                    parent.put(nd.right,nd);
                    q.add(nd.right);
                }
            }
        }
        return startingNode;
    }
    
    public int timeToBurnTree(TreeNode root, int start) {
        //your code goes here
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startingNode = markParentsAndReturnStartingNode(root,parent,start);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(startingNode);
        vis.put(startingNode,true);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burned  =false;
            for(int i=0;i<size;i++){
                TreeNode nd =  q.poll();
                if(nd.left!=null && vis.get(nd.left) == null){
                    q.add(nd.left);
                    vis.put(nd.left, true);
                    burned = true;
                }
                if(nd.right!=null && vis.get(nd.right) == null){
                    q.add(nd.right);
                    vis.put(nd.right, true);
                    burned = true;
                }
                if(parent.get(nd)!=null && vis.get(parent.get(nd)) == null){
                    q.add(parent.get(nd));
                    vis.put(parent.get(nd), true);
                    burned = true;
                }
            }
            if(burned) time++;
        }
        return time;
    }
}