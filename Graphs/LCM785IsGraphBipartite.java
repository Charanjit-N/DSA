// using BFS : TC->O(N + 2E), SC->O(2N)
class Solution {
    boolean bfs(int start, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int nd = q.poll();
            for(Integer x : graph[nd]){
                if(color[x] == -1){
                    q.add(x);
                    color[x] =  1- color[nd];
                }
                else if(color[x] == color[nd]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i =0 ;i<n;i++){
            if(color[i]==-1){
                if(bfs(i, graph, color) == false) return false;
            }
        }
        return true;
    }
}


// using DFS : TC->O(N + 2E), SC->O(2N)
class Solution {
    boolean dfs(int nd, int col, int[][] graph, int[] color){
        color[nd]=col;
        for(Integer x : graph[nd]){
            if(color[x]==-1){
                if(dfs(x, 1-col , graph, color) == false) return false;
            }
            else if(color[x] == color[nd]){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i =0 ;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,graph, color) == false) return false;
            }
        }
        return true;
    }
}