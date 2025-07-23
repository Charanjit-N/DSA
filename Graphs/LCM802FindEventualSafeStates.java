// Using BFS Topological Sort: TC->O(V+E) +O(v*logv): sorting , SC->O(4V)=O(V)
class Solution {
    public List<Integer> topoSortBFS(int V, List<List<Integer>> adj) {
        int[] inDegree =  new int[V];
        for(List<Integer> ls : adj){
            for(Integer x : ls){
                inDegree[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo =  new ArrayList<>();
        while(!q.isEmpty()){
            int nd =  q.poll();
            topo.add(nd);
            for(Integer x :  adj.get(nd)){
                inDegree[x]--;
                if(inDegree[x] == 0){
                    q.add(x);
                }
            }
        }
        return topo;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0;i<V;i++) adjRev.add(new ArrayList<>());
        for(int i =0;i<V;i++){
            for(int x :  graph[i]){
                adjRev.get(x).add(i);
            }
        }
        List<Integer> ans = topoSortBFS(V, adjRev);
        Collections.sort(ans);
        return ans;
    }
}


// Using DFS : TC->O(V+E) +O(V*logV): for sorting , SC->O(3V)=O(V)
class Solution {
    boolean dfs(int node, int[][] adj , int[] vis, int[] pathVis){
        vis[node] =1;
        pathVis[node] =1;
        for(int x :  adj[node]){
            if(vis[x]==0){
                if(dfs(x,adj,vis,pathVis) == true) return true;
            }
            else if(pathVis[x] == 1) return true;
        }
        pathVis[node] = 0; // unmark in pathVis while backtracking
        return false;
    }
   

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis =  new int[V];
        int[] pathVis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pathVis);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(pathVis[i] == 0){
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

