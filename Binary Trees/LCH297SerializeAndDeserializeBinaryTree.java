/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// TC->O(N), SC->O(N)
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode nd =  q.poll();
            if(nd ==  null){
                str.append("# ");   
            }
            else{
                str.append(nd.val+" ");
                q.add(nd.left);
                q.add(nd.right);
            }
        }
        return str.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data  == "") return null;
        String[] values = data.split(" ");
        Queue<TreeNode> q =  new LinkedList<>();
        TreeNode root =  new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent = q.poll();
            if(!values[i].equals("#")){
                TreeNode leftChild =  new TreeNode(Integer.parseInt(values[i]));
                parent.left = leftChild;
                q.add(leftChild);
            }
            i++;
            if(!values[i].equals("#")){
                TreeNode rightChild =  new TreeNode(Integer.parseInt(values[i]));
                parent.right = rightChild;
                q.add(rightChild);
            }
        } 

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));