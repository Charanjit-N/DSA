class Solution {
    int solve(int index1, int index2 , String text1, String text2,int[][] dp,List<Character> lcs){
        if(index1 < 0 || index2 < 0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(text1.charAt(index1) ==  text2.charAt(index2)){
            lcs.add(text1.charAt(index1));
            return dp[index1][index2] = 1 + solve(index1-1, index2-1, text1, text2,dp,lcs);
        }
        return dp[index1][index2] = 0 +  Math.max(solve(index1-1, index2,text1,text2,dp,lcs), solve(index1, index2-1,text1,text2,dp,lcs));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        List<Character> lcs = new ArrayList<>();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        int ans = solve(m-1,n-1,text1,text2,dp,lcs);
        for(int i=lcs.size()-1;i>=0;i--){
            System.out.print(lcs.get(i));
        }
        return ans;
    }
}



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
        int i=m , j =n;
        int lcsSize =  dp[m][n];
        char[] ans = new char[lcsSize];
        int index = lcsSize -1;
        while(i>0 && j>0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ans[index] = text1.charAt(i-1);
                index--;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println(Arrays.toString(ans));
        return dp[m][n];
    }
}