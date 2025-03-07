//TC->O(V + E) , SC->O(2*E)
class GFG_CreateAdjacencyListOfAGraph{
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adj  = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            
        }
        return adj;
    }
}