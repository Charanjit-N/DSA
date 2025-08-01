// TC->O(V+E) : topo sort + O(V+E) , SC->O(V)
class Pair{
  int neighbour;
  int weight;
  Pair(int neighbour, int weight){
    this.neighbour = neighbour;
    this.weight = weight;
  }
}
class TUFShortestPathInDAG {
    void topoDfs(int node,ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st ){
        vis[node]=1;
        for(Pair p :  adj.get(node)){
            int neigh =  p.neighbour;
            if(vis[neigh]==0){
                topoDfs(neigh,adj,vis,st);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj  =  new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        int[] vis =  new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<N;i++){
            if(vis[i]==0){
                topoDfs(i,adj,vis,st);
            }
        }
        int[] dist = new int[N];
        for(int i = 0;i<N;i++){
            dist[i] = (int)1e9;
        }
        int src = 0;
        dist[src] = 0;
        while(!st.isEmpty()){    // O(V + E)
            int node =  st.pop();
            for(Pair p :  adj.get(node)){
                int neigh =  p.neighbour;
                int wt =  p.weight;
                if(dist[node]+wt < dist[neigh]){
                dist[neigh] = dist[node] + wt;
                }
            }
        }
        for(int i=0;i<N;i++){
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        return dist;
    }
}