// TC-> O(E * logV) + O(V)
class AdjPair{
    int adjNode;
    int weight;
    AdjPair(int adjNode, int weight){
        this.adjNode =  adjNode;
        this.weight = weight;
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
    List<Integer>  pathUsingDijkstra(int V, ArrayList<ArrayList<AdjPair>> adj, int source, int destination ){
       PriorityQueue<Pair> pq =  new PriorityQueue<>((x,y) ->  x.distance -  y.distance);
       int[] dist =  new int[V];
       int[] cameFrom = new int[V];
       for(int i=0;i<V;i++){
        cameFrom[i] = i;
       }
       for(int i=0;i<V;i++){
        if(i==source) dist[i] = 0;
        else dist[i]  = (int)1e9;
       }
       pq.add(new Pair(0,source));
       while(!pq.isEmpty()){
        Pair p =  pq.poll();
        int nd =  p.node;
        int dis =  p.distance;
        for(AdjPair pp :  adj.get(nd)){
            int neigh = pp.adjNode;
            int wt =  pp.weight;
            if(dis + wt < dist[neigh]){
                dist[neigh] =  dis + wt;
                pq.add(new Pair(dist[neigh], neigh));
                cameFrom[neigh] = nd;
            }
        }
       }
       List<Integer> path = new ArrayList<>();
       if(dist[destination] == (int)1e9){
            path.add(-1);
            return path;
       }
       int nd =  destination;
       while(cameFrom[nd] != nd){
            path.add(nd);
            nd = cameFrom[nd];
       }
       path.add(nd);
       Collections.reverse(path);
       return path;
    }
    public List<Integer> shortestPath(int n, int source, int destination, int edges[][]) {
        ArrayList<ArrayList<AdjPair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new AdjPair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new AdjPair(edges[i][0],edges[i][2]));
        }
        return  pathUsingDijkstra(n,adj,source,destination);  
    }
}