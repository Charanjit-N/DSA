// Using Priority Queue
// TC-> O(E * logV)
class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance =  distance;
        this.node =  node;
    }
}
class Solution
{
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
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
        for(ArrayList<Integer> ls :  adj.get(nd)){
            int neigh =  ls.get(0);
            int wt =  ls.get(1);
            if(dis + wt < dist[neigh]){
                dist[neigh] =  dis + wt;
                pq.add(new Pair(dist[neigh], neigh));
            }
        }
       }
       return dist;
    }
}


// Using Set(TreeSet) 
// TC->O(E * logV)
class Pair {
    int distance;
    int node;
    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
    // Override equals and hashCode so that TreeSet can correctly remove elements
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return distance == p.distance && node == p.node;
    }
    @Override
    public int hashCode() {
        return Objects.hash(distance, node);
    }
}

class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.distance != b.distance)
                return a.distance - b.distance;
            return a.node - b.node; // prevent TreeSet from treating different nodes with same distance as equal
        });
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        set.add(new Pair(0, S));
        while (!set.isEmpty()) {
            Pair current = set.pollFirst(); // removes and returns the smallest element
            int node = current.node;
            int distance = current.distance;
            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);

                if (distance + edgeWeight < dist[adjNode]) {
                    // If already in the set with older distance, remove it
                    if (dist[adjNode] != (int) 1e9) {
                        set.remove(new Pair(dist[adjNode], adjNode));
                    }
                    dist[adjNode] = distance + edgeWeight;
                    set.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
