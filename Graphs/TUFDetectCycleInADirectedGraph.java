// using DFS : TC->O(V+E), SC->O(3V):recursion stack space, vis[] , pathVis[]
class TUFDetectCycleInADirectedGraph {
    boolean dfs(int node, List<List<Integer>> adj , int[] vis, int[] pathVis){
        vis[node] =1;
        pathVis[node] =1;
        for(Integer x :  adj.get(node)){
            if(vis[x]==0){
                if(dfs(x,adj,vis,pathVis) == true) return true;
            }
            else if(pathVis[x] == 1) return true;
        }
        pathVis[node] = 0; // unmark in pathVis while backtracking
        return false;
    }
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        int[] vis =  new int[N];
        int[] pathVis = new int[N];
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis)== true) return true;
            }
        }
        return false; 
    }
}

//Using DFS and getting nodes in Topological orfder if no cycle
// TC->O(V+E), SC->O(V)
class Check2 {
    boolean dfs(int node,List<List<Integer>> adj, int[] vis,int[] pathVis ,Stack<Integer> st ){
        vis[node]=1;
        pathVis[node]=1;
        for(Integer x :  adj.get(node)){
            if(vis[x]==0){
                if(dfs(x,adj,vis,pathVis,st)== true) return true;
            }
            else if(pathVis[node]==1) return true;
        }
        pathVis[node] = 0;
        st.push(node);
        return false;
    }
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] vis =  new int[V];
        int[] pathVis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis,st) == true) return new int[0];
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





// Using BFS / Topologic Sort / Kahn's Algo
// TC->O(V+E), SC->O(2V)=O(V);
class Solution {
    public int topoSortBFS(int V, List<List<Integer>> adj) {
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
        int cnt = 0;
        while(!q.isEmpty()){
            int nd =  q.poll();
            cnt++;
            for(Integer x :  adj.get(nd)){
                inDegree[x]--;
                if(inDegree[x] == 0){
                    q.add(x);
                }
            }
        }
        return cnt;
    }
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        int cnt = topoSortBFS(V, adj);
        if(cnt ==  V) return false;
        else return true;  
    }
}
