// TC -> O(N) + O(2E) , SC->O(3N)  , N-># nodes , E -> # Edges

class GFG_BFSTraversalOfGraph {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       ArrayList<Integer> bfs = new ArrayList<>();
       boolean vis[]  = new boolean[V];
       Queue<Integer> q = new LinkedList<>();
       q.add(0);
       vis[0] = true;
       while(!q.isEmpty()){
           Integer node = q.poll();
           bfs.add(node);
           for(Integer x :  adj.get(node)){
               if(vis[x] == false){
                   q.add(x);
                   vis[x] = true;
               }
           }
       }
       return bfs;
    }
}