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
    public int minOperations(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int lcs = longestCommonSubsequence(str1, str2);
        int deletion =  m - lcs;
        int insertion = n - lcs;
        return deletion + insertion ;
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
    public int minOperations(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int lcs = longestCommonSubsequence(str1, str2);
        int deletion =  m - lcs;
        int insertion = n - lcs;
        return deletion + insertion ;
    }
}

