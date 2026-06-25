/*
You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.
*/
class Solution {
    int maxLen = -1;
    void dfs(int nd, int[] edges, int[] vis, int[] pathVis, int[] cnt){
        vis[nd] = 1;
        pathVis[nd] = 1;
        int neigh = edges[nd];
        if( neigh != -1){
            if(vis[neigh] == 0){
                cnt[neigh] = cnt[nd] + 1;
                dfs(neigh, edges, vis, pathVis, cnt);
            }else{
                if(pathVis[neigh] == 1){
                    maxLen = Math.max(maxLen, cnt[nd] - cnt[neigh] + 1);
                }
            }
        }
        pathVis[nd] = 0;
        cnt[nd] = 1;
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,edges,vis,pathVis,cnt);
                System.out.println(maxLen);
            }
        }
        return maxLen;
    }
}