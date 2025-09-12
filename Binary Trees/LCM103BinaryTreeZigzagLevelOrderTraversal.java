// TC->O(n), SC->O(n)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] temp = new Integer[size]; 
            for (int i = 0; i < size; i++) {
                TreeNode nd = q.poll();
                int index = leftToRight ? i : size - 1 - i;
                temp[index] = nd.val;
                if (nd.left != null) q.add(nd.left);
                if (nd.right != null) q.add(nd.right);
            }
            ans.add(Arrays.asList(temp));
            leftToRight = !leftToRight;
        }

        return ans;
    }
}


// TC->O(n), SC->O(n)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        int rev = 1;
        while(!q.isEmpty()){
            rev = 1 - rev;
            List<Integer> ls = new ArrayList<>();

            int size =  q.size();
            
            for(int i=0;i<size;i++){
                TreeNode nd =  q.poll();
                ls.add(nd.val);
                if(nd.left != null) q.add(nd.left);
                if(nd.right != null) q.add(nd.right);
            }
            if(rev==1 ){
                Collections.reverse(ls);
                ans.add(ls);
            }
            else ans.add(ls);
        }
        return ans;
    }
}