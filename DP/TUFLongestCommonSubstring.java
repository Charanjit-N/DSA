// tabulation : Tc->O(m x n) , SC->O(m x n) : dp array
class TUFLongestCommonSubstring {
    static int longestCommonSubstr(String str1, String str2) {
      int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int index2=0;index2<=n;index2++) dp[0][index2] = 0;        
        for(int index1=0;index1<=m;index1++) dp[index1][0] =0;
        int ans = (int)-1e9;
        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(str1.charAt(index1-1) ==  str2.charAt(index2-1)){
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                    ans = Math.max(ans, dp[index1][index2]);
                }
                else   dp[index1][index2] = 0 ;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        String str1 =  "abcdxyz";
        String str2 =  "xyzabcd";
        System.out.println(longestCommonSubstr(str1,str2));
    }
}


// tabulation with space optimization : Tc->O(m x n) , SC->O(n) : extra arrays
class TUFLongestCommonSubstring {
    static int longestCommonSubstr(String str1, String str2) {
      int m = str1.length();
        int n = str2.length();
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];
        int ans = (int)-1e9;
        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(str1.charAt(index1-1) ==  str2.charAt(index2-1)){
                    cur[index2] = 1 + prev[index2-1];
                    ans = Math.max(ans, cur[index2]);
                }
                else cur[index2] = 0 ;  
            }
            for(int index2=0;index2<=n;index2++){
                prev[index2] = cur[index2];
            }
        }
        return ans;
    }
    public static void main(String args[]){
        String str1 =  "abcdxyz";
        String str2 =  "xyzabcd";
        System.out.println(longestCommonSubstr(str1,str2));
    }
}