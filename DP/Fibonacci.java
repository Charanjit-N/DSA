
// import java.util.Arrays;


// // Memoization
// class Fibonacci{
//     static int fib(int n , int[] dp){
//         if(n<=1) return n;
//         if(dp[n] != -1) return dp[n];      // step 2
//         return dp[n] = fib(n-1, dp) + fib(n-2, dp);   // step 3
//     }
//     public static void main(String args[]){
//         int n = 5;
//         int[] dp = new int[n+1];    // step 1
//         Arrays.fill(dp, -1);
//         System.out.println(fib(n, dp));

//     }
// }


// // tabulation
// class Fibonacci{
//     public static void main(String args[]){
//         int n = 5;
//         int[] dp = new int[n+1];
//         dp[0] = 0;
//         dp[1] =1;
//         for(int i=2;i<=n;i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         System.out.print(dp[n]);
//     }
// }


// tabulation with space otimization 

class Fibonacci{
    public static void main(String[] arg){
        int n = 5;
        int[] dp = new int[n+1];
        int prev2 = 0;
        int prev1 =1;
        for(int i=2;i<=n;i++){
            int curr = prev1 + prev2;
            prev2 =  prev1;
            prev1 =  curr;
        }
        System.out.print(prev1);
    }
}


