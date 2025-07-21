// using DFS : TC->O(V+E), SC->O(3V):recursion stack space, vis[] , pathVis[]
class TUFDetectCycleInADirectedGraph {
    boolean dfs(int node, List<List<Integer>> adj , int[] vis, int[] pathVis){
        vis[node] =1;
        pathVis[node] =1;
        for(Integer x :  adj.get(node)){
            if(vis[x]==0){
                if(dfs(x,adj,vis,pathVis) == true) return true;
            }
            else if(pathVis[x] == 1) return true;
        }
        pathVis[node] = 0; // unmark in pathVis while backtracking
        return false;
    }
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        int[] vis =  new int[N];
        int[] pathVis = new int[N];
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis)== true) return true;
            }
        }
        return false; 
    }
}
