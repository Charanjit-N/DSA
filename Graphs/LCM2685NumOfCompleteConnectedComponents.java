/*
A connected component is a subgraph of a graph in which there exists a edge/connection between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

Approach 1 :  let a components has compNodes, compEdges then for complete :
      (commpNodes * (compNodes-1)) /2  =  compEdges/2  
      (we are computing each edges twice in travesal function so compEdges/2)

Approach 2 : get the nodes of a component for each node in component as according to complete definiton it should be connected to all other nodes except itself
so adj.get(that node).size() should be == component.size() - 1 for completeness.
*/

// Given undirested graph : TC-> O(N + 2E), N-> # vertices , E-> Edges in graph

// Approach 1
class LCM2685NumOfCompleteConnectedComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        int cnt = 0;
        // Adj List Creation
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // use BFS or DFS to traverse graph
        int vis[] = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                int[] arr = bfs(i, adj, vis);
                int compNodes = arr[0];
                int compEdges = arr[1];
                if(compNodes * (compNodes-1) ==  compEdges) cnt++;
            }
        }
        return cnt; 
    }
    int[] bfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 1;
        int compNodes=0;
        int compEdges = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            compNodes++;
            compEdges += adj.get(node).size();
            for(Integer x : adj.get(node)){
                if(vis[x]==0){
                    vis[x] = 1;
                    q.add(x);
                }
            }
        }
        return new int[]{compNodes, compEdges};
    }
}

// Approach 2
class LCM2685NumOfCompleteConnectedComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        int cnt = 0;
        // Adj List creation
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int vis[] = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                boolean isComp = true;
                ArrayList<Integer> ls = bfs(i, adj, vis);
                for(int k : ls){
                    if(adj.get(k).size() != ls.size()-1){
                        isComp = false;
                        break;
                    }
                }
                if(isComp == true) cnt++;
            }
        }
        return cnt;
    }

    ArrayList<Integer> bfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 1;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        while(!q.isEmpty()){
            Integer node = q.poll();
            ls.add(node);
            for(Integer x : adj.get(node)){
                if(vis[x]==0){
                    vis[x] = 1;
                    q.add(x);
                }
            }
        }
        return ls;
    }
}
