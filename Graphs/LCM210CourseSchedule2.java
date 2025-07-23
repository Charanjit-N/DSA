// TC->O(V+E), SC->O(4V)=O(V);
class Solution {
    public int[] topoSortBFS(int V, List<List<Integer>> adj) {
        int[] inDegree =  new int[V];
        for(List<Integer> ls : adj){
            for(Integer x : ls){
                inDegree[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int index = 0;
        int[] topo =  new int[V];
        while(!q.isEmpty()){
            int nd =  q.poll();
            topo[index++]= nd;
            for(Integer x :  adj.get(nd)){
                inDegree[x]--;
                if(inDegree[x] == 0){
                    q.add(x);
                }
            }
        }
        if(index==V) return topo;
        else return new int[0];
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i=0;i<numCourses;i++){       // Adjacency list building
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
        }
       return topoSortBFS(numCourses, adj);
    }
        
}