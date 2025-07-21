// TC->O(N^2) , SC->O(n)
class Solution {
    void bfs(int start, int[][] isConnected , int[] vis){
        Queue<Integer> q =  new LinkedList<>();
        q.add(start);
        vis[start]=1;
        while(!q.isEmpty()){
            int nodeVal = q.poll();
           
            for(int row=0;row <isConnected.length;row++){
                if(isConnected[row][nodeVal-1]==1){
                    if(vis[row+1] == 0){
                        q.add(row+1);
                        vis[row+1]=1;
                    }
                }
            } 
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n =  isConnected.length;
        int[] vis = new int[n+1];
        int cnt = 0;
        for(int i=1;i<=n;i++){
            if(vis[i] == 0){
                cnt++;
                bfs(i,isConnected,vis);
            }
        }
        return cnt;
        
    }
}