import java.util.Arrays;
// Recursion : TC-> O(Exponential), SC->O(n) : recursion satck space
// class TUFMatrixChainMultiplication {
//     static int solve(int i , int j, int[] nums){
//         if(i==j) return 0;

//         int min  =  (int)1e9;
//         for(int k=i ;k<=j-1;k++){
//            int operations = nums[i-1]*nums[k]*nums[j] + solve(i,k,nums)+ solve(k+1,j,nums);
//            min = Math.min(min, operations);
//         }
//         return min;
//     }
//     public static void main(String args[]){
//         int[] nums = {10,15,20,25};
//         int n = nums.length;
//         System.out.println(solve(1,n-1,nums));
//     }
// }



// Memoization : TC-> O(n^3), SC->O(n) : recursion satck space + O(n^2) : dp array
// class TUFMatrixChainMultiplication {
//     static int solve(int i , int j, int[] nums,int[][] dp){
//         if(i==j) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         int min  =  (int)1e9;
//         for(int k=i ;k<=j-1;k++){
//            int operations = nums[i-1]*nums[k]*nums[j] + solve(i,k,nums,dp)+ solve(k+1,j,nums,dp);
//            min = Math.min(min, operations);
//         }
//         return dp[i][j] = min;
//     }
//     public static void main(String args[]){
//         int[] nums = {10,15,20,25};
//         int n = nums.length;
//         int[][] dp = new int[n][n];
//         for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
//         System.out.println(solve(1,n-1,nums,dp));
//     }
// }


// Tabulation : TC-> O(n^3), SC->O(n^2) : dp array
class TUFMatrixChainMultiplication {
    public static void main(String args[]){
        int[] nums = {10,15,20,25};
        int n = nums.length;
        int[][] dp = new int[n][n];
        //base case
        for(int i=0;i<n;i++) dp[i][i] = 0;
        for(int i=n-1;i>=1;i--){
            for(int j = i+1;j<=n-1;j++){
                int min  =  (int)1e9;
                for(int k=i ;k<=j-1;k++){
                    int operations = nums[i-1]*nums[k]*nums[j] + dp[i][k]+ dp[k+1][j];
                    min = Math.min(min, operations);
                }
                dp[i][j] = min;

            }
        }
        System.out.println(dp[1][n-1]);
    }
}