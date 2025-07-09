import java.util.Arrays;

// Recursion : TC->O(Exponential), SC->O(n) : recursion stack space 
class TUFDifferentWaysToEvaluateABooleanExpression {
    static int solve(int i , int j , int needTrue, String s){
        if(i>j) return 0;
        if(i==j){
            if(needTrue==1) return (s.charAt(i) == 'T') ? 1:0;
            else return (s.charAt(i) == 'F') ? 1:0;
        }
        int ways = 0;
        for(int k = i+1;k<=j-1;k+=2){
            int leftTrue = solve(i,k-1,1,s);
            int leftFalse = solve(i,k-1,0,s);
            int rightTrue = solve(k+1,j,1,s);
            int rightFalse = solve(k+1,j,0,s);
            
            if(s.charAt(k) == '&'){
                if(needTrue==1) ways = ways +  leftTrue * rightTrue;
                else ways = ways +  leftFalse*rightTrue + leftTrue*rightFalse + leftFalse*rightFalse;
            }
            else if(s.charAt(k) == '|'){
                if(needTrue ==  1) ways = ways + leftFalse*rightTrue + leftTrue*rightFalse + leftTrue * rightTrue;
                else ways =  ways  +  leftFalse*rightFalse;
            }
            else if(s.charAt(k) == '^'){
                if(needTrue == 1) ways = ways  +  leftFalse*rightTrue + leftTrue*rightFalse;
                else ways = ways +  leftFalse*rightFalse + leftTrue * rightTrue;
            }   
        }
        return ways;
    }
    static public int countTrue(String s) {
        int n = s.length();
        return solve(0,n-1,1,s,dp);
    }
    public static void main(String args[]){
        String s = "T|T&F^T";
        System.out.println(countTrue(s));
    }
}


// Memoization : TC->O(n*n*2*n) = O(n^3), SC->O(n*n*2): dp array + O(n) : recursion stack space 
class TUFDifferentWaysToEvaluateABooleanExpression {
    static int solve(int i , int j , int needTrue, String s,int[][][] dp){
        if(i>j) return 0;
        if(i==j){
            if(needTrue==1) return (s.charAt(i) == 'T') ? 1:0;
            else return (s.charAt(i) == 'F') ? 1:0;
        }
        if(dp[i][j][needTrue] != -1) return dp[i][j][needTrue];
        int ways = 0;
        for(int k = i+1;k<=j-1;k+=2){
            int leftTrue = solve(i,k-1,1,s,dp);
            int leftFalse = solve(i,k-1,0,s,dp);
            int rightTrue = solve(k+1,j,1,s,dp);
            int rightFalse = solve(k+1,j,0,s,dp);
            if(s.charAt(k) == '&'){
                if(needTrue==1) ways = ways +  leftTrue * rightTrue;
                else ways = ways +  leftFalse*rightTrue + leftTrue*rightFalse + leftFalse*rightFalse;
            }
            else if(s.charAt(k) == '|'){
                if(needTrue ==  1) ways = ways + leftFalse*rightTrue + leftTrue*rightFalse + leftTrue * rightTrue;
                else ways =  ways  +  leftFalse*rightFalse;
            }
            else if(s.charAt(k) == '^'){
                if(needTrue == 1) ways = ways  +  leftFalse*rightTrue + leftTrue*rightFalse;
                else ways = ways +  leftFalse*rightFalse + leftTrue * rightTrue;
            }   
        }
        return dp[i][j][needTrue] = ways;
    }
    static public int countTrue(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,n-1,1,s,dp);
    }
    public static void main(String args[]){
        String s = "T|T&F^T";
        System.out.println(countTrue(s));
    }
}
