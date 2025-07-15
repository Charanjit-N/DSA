
// DFS / recursion
// TC->O(N) + O(N), SC->O(N) + O(N) +O(N)
class Solution {
    void markParents(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parent.put(root, null);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode nd =  q.poll();
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
    }
    void solve(TreeNode node , int k, Map<TreeNode, TreeNode> parent, Map<TreeNode, Boolean> vis, List<Integer> ans){
        if(node==null || k < 0) return;
        if(k==0){
            ans.add(node.val);
            return;
        }
        vis.put(node,true);
        if(node.left != null && vis.get(node.left) == null) solve(node.left, k-1,parent,vis,ans);
        if(node.right != null && vis.get(node.right) == null) solve(node.right, k-1,parent,vis,ans);
        if(parent.get(node) != null && vis.get(parent.get(node)) == null) solve(parent.get(node), k-1, parent,vis, ans);

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root,parent);
        Map<TreeNode, Boolean> vis = new HashMap<>();

        List<Integer> ans = new ArrayList<>();
        solve(target, k,parent,vis,ans);
        return ans;
    }
}




// BFS/ Level order traversal
// TC->O(N) + O(N), SC->O(N) + O(N) +O(N)
class Solution {
    void markParents(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parent.put(root, null);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode nd =  q.poll();
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
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root,parent);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target,true);
        int curLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curLevel ==k) break;
            curLevel++;
            for(int i=0;i<size;i++){
                TreeNode nd =  q.poll();
                if(nd.left!=null && vis.get(nd.left) == null){
                    q.add(nd.left);
                    vis.put(nd.left, true);
                }
                if(nd.right!=null && vis.get(nd.right) == null){
                    q.add(nd.right);
                    vis.put(nd.right, true);
                }

                if(parent.get(nd)!=null && vis.get(parent.get(nd)) == null){
                    q.add(parent.get(nd));
                    vis.put(parent.get(nd), true);
                }

            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}