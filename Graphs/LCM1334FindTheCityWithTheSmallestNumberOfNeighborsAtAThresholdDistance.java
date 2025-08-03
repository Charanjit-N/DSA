// Using Flod Warshall : TC-> O(n^3)
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(adj[i], (int)1e9);
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt =  edges[i][2];
            adj[u][v] = wt;
            adj[v][u] = wt;
        }
        for(int i =0;i<n;i++){
            adj[i][i] = 0;
        }
        for(int via = 0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adj[i][j] =  Math.min(adj[i][j] , adj[i][via] + adj[via][j]);
                }
            }
        }
        int minCnt =  Integer.MAX_VALUE;
        int city = -1;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(adj[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <=  minCnt){
                minCnt =  cnt;
                city =  i;
            }
        }
        return city;
    }
}


// using Dijkstars Algo for each node
// TC---> O(V * (E*logV))
class AdjPair{
    int node;
    int wt;
    AdjPair(int node, int wt){
        this.node =  node;
        this.wt =  wt;  
    }
}
class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance =  distance;
        this.node =  node;
    }
}
class Solution {
    public  int[] dijkstra(int V, ArrayList<ArrayList<AdjPair>> adj, int S){
       PriorityQueue<Pair> pq =  new PriorityQueue<>((x,y) ->  x.distance -  y.distance);
       int[] dist =  new int[V];
       for(int i=0;i<V;i++){
        if(i==S) dist[i] = 0;
        else dist[i]  = (int)1e9;
       }
       pq.add(new Pair(0,S));
       while(!pq.isEmpty()){
        Pair p =  pq.poll();
        int nd =  p.node;
        int dis =  p.distance;
        for(AdjPair ap :  adj.get(nd)){
            int neigh =  ap.node;
            int wt =  ap.wt;
            if(dis + wt < dist[neigh]){
                dist[neigh] =  dis + wt;
                pq.add(new Pair(dist[neigh], neigh));
            }
        }
       }
       return dist;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<AdjPair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new AdjPair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new AdjPair(edges[i][0], edges[i][2]));
        }
        int[][] dist = new int[n][n];
        for(int i =0;i<n;i++){
            dist[i] = dijkstra(n,adj,i);
        }
        int minCnt =  Integer.MAX_VALUE;
        int city = -1;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(dist[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <=  minCnt){
                minCnt =  cnt;
                city =  i;
            }
        }
        return city;
    }
}








