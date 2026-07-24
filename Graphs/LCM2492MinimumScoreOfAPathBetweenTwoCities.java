// Given there will be for suure a path between 1, n so min edge in the componen having 1,n is our answer
// Apply any traversal to get min edge
// TC -->O(v+E)

class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : roads){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        
        // find the minedge in the graph component that has 1,n
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n+1];
        vis[1] = 1;
        q.add(1);
        int minEdge  =  Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int nd = q.poll();
            for(int[] neigh : adj.get(nd)){
                int neigh_nd = neigh[0];
                int neigh_wt = neigh[1];
                minEdge = Math.min(minEdge,neigh_wt);
                if(vis[neigh_nd] != 1){
                    q.add(neigh_nd);
                    vis[neigh_nd] = 1;
                }
            }
        }
        return minEdge;

    }
}