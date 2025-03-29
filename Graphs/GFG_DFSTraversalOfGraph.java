
// TC -> O(N) + O(2E) , SC->O(3N)  , N-># nodes , E -> # Edges
class GFG_DFSTraversalOfGraph {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[adj.size()];
        vis[0] = true;
        ArrayList<Integer> dfs = new ArrayList<>();
        performDfs(0, vis, adj, dfs);
        return dfs;
    }
    void performDfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs)
    {
        vis[node] = true;
        dfs.add(node);
        for(Integer x : adj.get(node)){
            if(vis[x] == false){
                performDfs(x, vis, adj , dfs);
            }
        }
    }
}