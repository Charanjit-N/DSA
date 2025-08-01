// BFS : TC->O(V + 2E) , SC->O(V)
class Solution {
    public int[] shortestPath(int[][] edges, int N, int M, int start) {
      List<List<Integer>> adj = new ArrayList<>();
      for(int i =0 ; i <M;i++){
        adj.add(new ArrayList<>());
      }
      for(int i=0;i<M;i++){
        adj.get(edges[i][0]).add(edges[i][1]);
        adj.get(edges[i][1]).add(edges[i][0]);
      }
      Queue<Integer> q = new LinkedList<>();
      int[] dist = new int[N];
      for(int i=1;i<N;i++){
        dist[i] = Integer.MAX_VALUE;
      }
      q.add(start);
      dist[start] = 0;
      while(!q.isEmpty()){
        int nd =  q.poll();
        for(int x :  adj.get(nd)){
          if(1 + dist[nd] < dist[x]){
            dist[x] =  1 +  dist[nd];
            q.add(x);
          }
        }
      }
      return dist;
    }
}
