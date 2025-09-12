//Using BFS
// TC->O(V+2E), SC->O(V)
class Pair{
    int node;
    int cameFrom;
    Pair(int node, int cameFrom){
        this.node = node;
        this.cameFrom = cameFrom;
    }
}
class Solution {
    boolean bfs(int startNode,List<Integer>[] adj,int[] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startNode,-1));
        vis[startNode] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int val = p.node;
            int cf = p.cameFrom;
            for(Integer x : adj[val]){
                if(vis[x] == 0){
                    vis[x] = 1;
                    q.add(new Pair(x,val));
                }
                else if(vis[x] == 1 && x!=cf) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        int[] vis = new int[adj.length];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(bfs(i,adj,vis)) return true;
            }
        }
        return false;
    }
}




// USing DFS :  TC->O(V+2E), SC->O(V)
class Solution {
    boolean dfs(int node,int cameFrom,List<Integer>[] adj,int[] vis){
        vis[node] = 1;
        for(Integer x :  adj[node]){
            if(vis[x]==0){
                if(dfs(x,node,adj,vis)== true) return true;
            }
            else if(vis[x]==1 && x!=cameFrom ){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        int[] vis = new int[adj.length];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,-1,adj,vis)) return true;
            }
        }
        return false;
    }
}
