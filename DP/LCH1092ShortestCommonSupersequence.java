// tabulation : Tc->O(m x n) , SC->O(m x n) : dp array
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int index2=0;index2<=n;index2++){
            dp[0][index2] = 0;
        }
        for(int index1=0;index1<=m;index1++){
            dp[index1][0] =0;
        }
        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(str1.charAt(index1-1) ==  str2.charAt(index2-1)){
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                }
                else{
                    dp[index1][index2] = 0 +  Math.max(dp[index1-1][index2], dp[index1][index2-1]);
                }
            }
        }
    //    int lenSCS = m + n - dp[m][n] // Length of Shortest Common Supersequence
       int i=m, j= n;
       String ans = "";
       while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans = str1.charAt(i-1) + ans;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                ans = str1.charAt(i-1) + ans;
                i--;
            }   
            else{
                ans = str2.charAt(j-1) + ans;
                j--;
            }  
       }
       while(i>0){
            ans = str1.charAt(i-1) + ans;
            i--;
       }
       while(j>0){
            ans = str2.charAt(j-1) + ans;
            j--;
       }
      return ans;     
    }
}