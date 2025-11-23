// Tabulation : TC ->O(len * m * n) , SC ->O(len * m * n )
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[len][2];
        for(int i=0;i<len;i++){
            String s =  strs[i];
            int cnt0 =0 ,cnt1=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '0') cnt0++;
                else cnt1++;
            }
            cnt[i][0] = cnt0;
            cnt[i][1] = cnt1;
        }
        
        int[][][] dp = new int[len][m+1][n+1];
        for(int j=0;j<=m;j++){
            for(int k=0;k<=n;k++){
                if(cnt[0][0]<=j && cnt[0][1]<=k) dp[0][j][k] = 1;
            }
        }

        for(int i=1;i<len;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    int notPick = 0 + dp[i-1][j][k];
                    int pick = (int)-1e9;
                    if(cnt[i][0] <= j && cnt[i][1] <= k) pick = 1 +  dp[i-1][j-cnt[i][0]][k-cnt[i][1]];
                    dp[i][j][k] = Math.max(notPick, pick);

                }
            }
        }
        return dp[len-1][m][n];
    }
}



// Memoization TC ->O(len * m * n) , SC -> O(len * m * n ) + recursion stack space
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[len][2];
        for(int i=0;i<len;i++){
            String s =  strs[i];
            int cnt0 =0 ,cnt1=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '0') cnt0++;
                else cnt1++;
            }
            cnt[i][0] = cnt0;
            cnt[i][1] = cnt1;
        }
        int[][][] dp = new int[len][m+1][n+1];
        for(int i=0;i<len;i++){
            for(int j=0;j<=m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(strs, m,n, len-1,cnt,dp);
    }
    int solve(String[] strs, int m , int n, int index, int[][] cnt,int[][][] dp){
        if(index==0){
            if(m-cnt[index][0]>=0 && n-cnt[index][1]>=0) return 1;
            else return 0;
        }
        if(dp[index][m][n] != -1) return dp[index][m][n];
        int notPick = 0 +  solve(strs, m,n,index-1,cnt,dp);
        int pick =  (int)-1e9;
        if(cnt[index][0] <= m && cnt[index][1] <= n) pick = 1 +  solve(strs,m-cnt[index][0],n-cnt[index][1],index-1,cnt,dp);
        return dp[index][m][n] = Math.max(notPick, pick);   
    }
}



// Recursion  Tc-> Exponential
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[len][2];
        for(int i=0;i<len;i++){
            String s =  strs[i];
            int cnt0 =0 ,cnt1=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '0') cnt0++;
                else cnt1++;
            }
            cnt[i][0] = cnt0;
            cnt[i][1] = cnt1;
        }
        return solve(strs, m,n, len-1,cnt);
    }
    int solve(String[] strs, int m , int n, int index, int[][] cnt){
        if(index==0){
            if(m-cnt[index][0]>=0 && n-cnt[index][1]>=0) return 1;
            else return 0;
        }
        int notPick = 0 +  solve(strs, m,n,index-1,cnt);
        int pick =  (int)-1e9;
        if(cnt[index][0] <= m && cnt[index][1] <= n) pick = 1 +  solve(strs,m-cnt[index][0],n-cnt[index][1],index-1,cnt);
        return Math.max(notPick, pick);
    }
}