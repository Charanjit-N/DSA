// Online Java Compiler
// Use this editor to write, compile and run your Java code online


import java.util.*;
class Main {
    static int maxLen = -1;
    static void dfs(int nd, int cameFrom, List<List<Integer>> adj, int[] vis, int[] cnt){
        vis[nd] = 1;
        for(int neigh : adj.get(nd)){
            if(vis[neigh] == 0){
                cnt[neigh] = cnt[nd] + 1;
                dfs(neigh,nd, adj, vis, cnt);
            }else{
                if(neigh != cameFrom){
                    maxLen = Math.max(maxLen, cnt[nd] - cnt[neigh] + 1);
                }
            }
        }
        cnt[nd] = 1;
        vis[nd] = 0;
    }
    public static int longestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,-1,adj,vis,cnt);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int v = 12;
        int[][] edges = {{0,1},{1,2},{2,3},{3,0},{1,4},{4,5},{5,6},{6,7},{7,2},{7,8},{8,9},{9,10},{10,11},{11,0}};
        System.out.println(longestCycle(v,edges));
    }
}