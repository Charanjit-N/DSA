// Using Dijkstra's Algo : TC->O(E log V)
class Pair{
    long distance;
    int node;
    Pair(long distance, int node){
        this.distance =  distance;
        this.node =  node;
    }
}
class AdjPair{
    int node;
    int wt;
    AdjPair(int node, int wt){
        this.node =  node;
        this.wt =  wt;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod =  (int)(1e9+7);
        ArrayList<ArrayList<AdjPair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new AdjPair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new AdjPair(roads[i][0],roads[i][2]));
        }
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));
       long[] dist =  new long[n];
       Arrays.fill(dist, Long.MAX_VALUE);
       dist[0] = 0;
       int[] ways = new int[n];
       ways[0] = 1;
       pq.add(new Pair(0,0));
       while(!pq.isEmpty()){
        Pair p =  pq.poll();
        int nd =  p.node;
        long dis =  p.distance;
        for(AdjPair pp :  adj.get(nd)){
            int neigh =  pp.node;
            int wt =  pp.wt;
            if(dis + wt < dist[neigh]){
                dist[neigh] =  dis + wt;
                pq.add(new Pair(dist[neigh], neigh));
                ways[neigh] = ways[nd];
            }
            else if(dis + wt == dist[neigh]){
                ways[neigh] = (ways[neigh] + ways[nd])% mod;
            }
        }
       }
      
       return ways[n-1] % mod ;
        
    }
}