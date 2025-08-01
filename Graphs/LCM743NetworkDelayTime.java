// Using Dijkstras Algo : TC ->O(E * logV)
class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
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
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<AdjPair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new AdjPair(times[i][1],times[i][2]));
        }
        PriorityQueue<Pair> pq =  new PriorityQueue<>((x,y) ->  x.distance -  y.distance);
       int[] dist =  new int[n+1];
       for(int i=0;i<=n;i++){
        if(i==k) dist[i] = 0;
        else dist[i]  = (int)1e9;
       }
       pq.add(new Pair(0,k));
       while(!pq.isEmpty()){
        Pair p =  pq.poll();
        int nd =  p.node;
        int dis =  p.distance;
        for(AdjPair pp :  adj.get(nd)){
            int neigh =  pp.node;
            int wt =  pp.wt;
            if(dis + wt < dist[neigh]){
                dist[neigh] =  dis + wt;
                pq.add(new Pair(dist[neigh], neigh));
            }
        }
       }
       int max =  Integer.MIN_VALUE;
       for(int i=1;i<=n;i++){
            max =  Math.max(max, dist[i]);
       }
       return max == (int)1e9 ? -1 : max ;
    }
}