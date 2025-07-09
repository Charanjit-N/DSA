
// recursion : TC->O(Exponential), SC-> O(n) : recursion stack space
class Solution {
    boolean isPalindrome(int start, int end,String s ){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    int solve(int i,String s){
        if(i==s.length()) return 0;
        int minCost = Integer.MAX_VALUE;
        for(int k = i;k<s.length();k++){
            if(isPalindrome(i,k,s)){
                int cost = 1 + solve(k+1,s);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }
    public int minCut(String s) {
        return solve(0,s) -1 ;
    }
}

// memoization: TC->O(n^2), SC->O(n) : recursion stack space + O(n) : dp array
class Solution {
    boolean isPalindrome(int start, int end,String s ){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    int solve(int i,String s,int[] dp){
        if(i==s.length()) return 0;
        if(dp[i] != -1) return dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int k = i;k<s.length();k++){
            if(isPalindrome(i,k,s)){
                int cost = 1 + solve(k+1,s,dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,dp) -1 ;
    }
}


// Tabulation : TC->O(n^2) , SC->O(n) : dp array
class Solution {
    boolean isPalindrome(int start, int end,String s ){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int minCost = Integer.MAX_VALUE;
            for(int k = i;k<s.length();k++){
                if(isPalindrome(i,k,s)){
                    int cost = 1 + dp[k+1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0]-1 ;
    }
}