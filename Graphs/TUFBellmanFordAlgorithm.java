//  TC -> O(V * E)
class Solution {
    static int[] bellman_ford(int V,ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[S] = 0;
        for(int i=1;i<=V-1;i++){
            for(int e=0;e<edges.size();e++){
                int u = edges.get(e).get(0);
                int v = edges.get(e).get(1);
                int wt = edges.get(e).get(2);
                if(dist[u]+ wt <  dist[v]){
                    dist[v] =  dist[u] + wt;
                }
            }
        }
        // To check if -ve cycle is present
        for(int e=0;e<edges.size();e++){
            int u = edges.get(e).get(0);
            int v = edges.get(e).get(1);
            int wt = edges.get(e).get(2);
            if(dist[u]+ wt <  dist[v]){  // -ve cycle present.
                return new int[]{-1};
            }
        }
        return dist;
    }
}

