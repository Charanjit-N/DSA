// h TC->O(100000 * arr.length)
import java.util.*;
class Pair{
    int node;
    int steps;
    Pair(int node, int steps){
        this.node =  node;
        this.steps =  steps;
        
    }
}
class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {
       Queue<Pair> pq =  new LinkedList<>();
       int[] dist =  new int[100000];
       for(int i=0;i<dist.length;i++){
        if(i==start) dist[i] = 0;
        else dist[i]  = (int)1e9;
       }
       pq.add(new Pair(start,0));
       while(!pq.isEmpty()){
            Pair p =  pq.poll();
            int nd =  p.node;
            int steps =  p.steps;
            for(int i=0;i<arr.length;i++){
                int neigh =  (nd * arr[i]) % 100000;
                if(steps + 1 < dist[neigh]){
                    dist[neigh] = steps + 1;
                    if(neigh == end) return dist[neigh];
                    pq.add(new Pair( neigh, dist[neigh]));
                }
            }
       }
       return -1;
    }
}

