// TC -> O(n^3) , SC->O(n^2) : changing the distances in the same given adj matrix
class Solution {
    public void shortest_distance(int[][] adj) {
        int n = adj.length;
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj[i][j]==-1){
                    adj[i][j] = (int)1e9;
                }
            }
        }
        for(int via = 0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adj[i][j] =  Math.min(adj[i][j] , adj[i][via] + adj[via][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(adj[i][i] < 0){
                System.out.println("graph has -ve cycle");
            }
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(adj[i][j] == (int)1e9){
                    adj[i][j] = -1;
                }
            }
        }
    }
}

