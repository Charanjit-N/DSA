// TC --> O(E) =O(flights.length): using dijkstra algo with queu not priority queu so no extra logV
class Tuple{
    int stops;
    int node;
    int cost;
    Tuple(int stops, int node, int cost){
        this.stops =  stops;
        this.node = node;
        this.cost =  cost;
    }
}
class Pair{
    int adjNode;
    int wt;
    Pair(int adjNode, int wt){
        this.adjNode = adjNode;
        this.wt = wt;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int stops =  t.stops;
            int node = t.node;
            int cost = t.cost;
            if(stops > k) continue;
            for(Pair p : adj.get(node)){
                int adjNode =  p.adjNode;
                int wt = p.wt;
                if(cost +  wt < dist[adjNode] && stops <= k){
                    dist[adjNode] =  cost +  wt;
                    q.add(new Tuple(stops+1,adjNode, dist[adjNode]));
                }
            }
        }
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];   
    }
}