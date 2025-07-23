
//Using DFS : TC->O(V+E), SC->O(V)
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

// Using BFS : TC->O(V+E), SC->O(2V)=O(V);
class TUFTopologicalSort {
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
        int[] ans =  new int[V];
        while(!q.isEmpty()){
            int nd =  q.poll();
            ans[index++] = nd;
            for(Integer x :  adj.get(nd)){
                inDegree[x]--;
                if(inDegree[x] == 0){
                    q.add(x);
                }
            }
        }
        return ans;
    }
}