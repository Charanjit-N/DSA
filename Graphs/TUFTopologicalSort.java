//TC->O(V+E), SC->O(V)
class TUFTopologicalSort {
    void dfs(int node,List<List<Integer>> adj, int[] vis, Stack<Integer> st ){
        vis[node]=1;
        for(Integer x :  adj.get(node)){
            if(vis[x]==0){
                dfs(x,adj,vis,st);
            }
        }
        st.push(node);
    }
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] vis =  new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
        }
        int[] ans =  new int[V];
        int i =0;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i++;
        }
        return ans;
    }
}