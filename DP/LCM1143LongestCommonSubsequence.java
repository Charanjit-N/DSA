// Recursion: TC->O(2^m x 2^n) : we are trying our all possible comparision between all subsequences of string 1 and string2 ,SC->O(m+n) : recursion stack space in worst case if both string has not common subsequence.
class Solution {
    int solve(int index1, int index2 , String text1, String text2){
        if(index1 < 0 || index2 < 0) return 0;
        if(text1.charAt(index1) ==  text2.charAt(index2)){
            return 1 + solve(index1-1, index2-1, text1, text2);
        }
        return 0 +  Math.max(solve(index1-1, index2,text1,text2), solve(index1, index2-1,text1,text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return solve(m-1,n-1,text1,text2);
    }
}

// Memoization : Tc->O(m x n) , SC->O(m + n): recursion stack space + O(m x n) : dp array
class Solution {
    int solve(int index1, int index2 , String text1, String text2,int[][] dp){
        if(index1 < 0 || index2 < 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(text1.charAt(index1) ==  text2.charAt(index2)){
            return dp[index1][index2] = 1 + solve(index1-1, index2-1, text1, text2,dp);
        }
        return dp[index1][index2] = 0 +  Math.max(solve(index1-1, index2,text1,text2,dp), solve(index1, index2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return solve(m-1,n-1,text1,text2,dp);
        
    }
}

//Memoizatio(n (shifted indexes to one place right)
class Solution {
    int solve(int index1, int index2 , String text1, String text2,int[][] dp){
        if(index1 == 0 || index2 == 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(text1.charAt(index1-1) ==  text2.charAt(index2-1)){
            return dp[index1][index2] = 1 + solve(index1-1, index2-1, text1, text2,dp);
        }
        return dp[index1][index2] = 0 +  Math.max(solve(index1-1, index2,text1,text2,dp), solve(index1, index2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(dp[i],-1);
        return solve(m,n,text1,text2,dp);
        
    }
}

// tabulation : Tc->O(m x n) , SC->O(m x n) : dp array
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int index2=0;index2<=n;index2++){
            dp[0][index2] = 0;
        }
        for(int index1=0;index1<=m;index1++){
            dp[index1][0] =0;
        }
        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(text1.charAt(index1-1) ==  text2.charAt(index2-1)){
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                }
                else{
                    dp[index1][index2] = 0 +  Math.max(dp[index1-1][index2], dp[index1][index2-1]);
                }
            }
        }
        return dp[m][n];
    }
}


// tabulation with space optimization : Tc->O(m x n) , SC->O(n) : extra arrays
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] prev = new int[n+1];
        int[] cur = new int[n+1]; 
        for(int index2=0;index2<=n;index2++){
            prev[index2] = 0;
        }
        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(text1.charAt(index1-1) ==  text2.charAt(index2-1)){
                    cur[index2] = 1 + prev[index2-1];
                }
                else{
                    cur[index2] = 0 +  Math.max(prev[index2], cur[index2-1]);
                }
            }
            for(int index2=0;index2<=n;index2++){
                prev[index2] =  cur[index2];
            }
        }
        return prev[n];
    }
}