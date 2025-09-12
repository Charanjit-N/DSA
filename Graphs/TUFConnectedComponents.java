// TC->O(V+E) , SC->O(V+E)
class Solution {
   static void bfs(int start, List<List<Integer>> adj , int[] vis){
        Queue<Integer> q =  new LinkedList<>();
        q.add(start);
        vis[start]=1;
        while(!q.isEmpty()){
            int nodeVal = q.poll();
            for(Integer x : adj.get(nodeVal)){
                if(vis[x] == 0){
                    q.add(x);
                    vis[x]=1;
                }
            } 
        }
    }
    static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        //adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[V];
        int cnt = 0;
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                cnt++;
                bfs(i,adj,vis);
            }
        }
        return cnt;
    } 
}



