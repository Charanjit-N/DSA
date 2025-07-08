// recursion : TC->O(exponential) , SC->O(c) : recursion stack space
class Solution {
    int solve(int i, int j , int[] cut){
        if(i > j) return 0;
        int min = (int)1e9;
        for(int k = i;k<=j;k++){
            int cost  = cut[j+1] - cut[i-1] + solve(i, k-1,cut) 
            + solve(k+1,j,cut);
            min = Math.min(min, cost);
        }
        return min;
    }
    public int minCost(int n, int[] cuts) {
        int c =  cuts.length;
        int[] cut =  new int[c+2];
        cut[0] = 0;
        cut[c+1] = n;
        for(int i=0;i<c;i++){
            cut[i+1] = cuts[i];
        }
        Arrays.sort(cut);
        return solve(1,c,cut);
    }
}




// Memoization : TC ->O(c^3), SC->O(c^2) : dp array + O(c) : recursion stack space
class Solution {
    int solve(int i, int j , int[] cut,int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = (int)1e9;
        for(int k = i;k<=j;k++){
            int cost  = cut[j+1] - cut[i-1] + solve(i, k-1,cut,dp) + solve(k+1,j,cut,dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        int c =  cuts.length;
        int[] cut =  new int[c+2];
        cut[0] = 0;
        cut[c+1] = n;
        for(int i=0;i<c;i++){
            cut[i+1] = cuts[i];
        }
        Arrays.sort(cut);

        int[][] dp = new int[c+1][c+1];
        for(int x=0;x<=c;x++) Arrays.fill(dp[x] ,-1);
        return solve(1,c,cut,dp);
    }
}


// tabulation : TC->O(c^3) , SC->O(c^2) : dp array
class Solution {
    public int minCost(int n, int[] cuts) {
        int c =  cuts.length;
        int[] cut =  new int[c+2];
        cut[0] = 0;
        cut[c+1] = n;
        for(int i=0;i<c;i++){
            cut[i+1] = cuts[i];
        }
        Arrays.sort(cut);

        int[][] dp = new int[c+2][c+2];
        for(int i=c ;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i > j) continue;
                int min = (int)1e9;
                for(int k = i;k<=j;k++){
                    int cost  = cut[j+1] - cut[i-1] + dp[i][k-1] +  dp[k+1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }
}
