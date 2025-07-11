// recursion : TC->O(Exponential) , SC->O(n) : recursion stack space
class Solution {
    int solve(int i, int k , int[] arr){
        if(i == arr.length) return 0;
        int len =0;
        int maxEle =  Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j=i; j < Math.min(arr.length , i+k) ;j++){
            len++;
            maxEle =  Math.max(maxEle,arr[j]);
            int sum =  len*maxEle + solve(j+1,k,arr);
            maxSum =  Math.max(maxSum , sum);
        }
        return maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return solve(0,k,arr);
        
    }
}

// memoization : TC->O(n * k) , SC->O(n): dp array + O(n) : recursion stack space
class Solution {
    int solve(int i, int k , int[] arr,int[] dp){
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int len =0;
        int maxEle =  Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j=i; j < Math.min(arr.length , i+k) ;j++){
            len++;
            maxEle =  Math.max(maxEle,arr[j]);
            int sum =  len*maxEle + solve(j+1,k,arr,dp);
            maxSum =  Math.max(maxSum , sum);
        }
        return dp[i] = maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,k,arr,dp);
        
    }
}

// Tabulation : TC->O(n * k) , SC->O(n): dp array 
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        for(int i =  n-1;i>=0;i--){
            int len =0;
            int maxEle =  Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;
            for(int j=i; j < Math.min(arr.length , i+k) ;j++){
                len++;
                maxEle =  Math.max(maxEle,arr[j]);
                int sum =  len*maxEle + dp[j+1];
                maxSum =  Math.max(maxSum , sum);
            }
            dp[i] = maxSum;
        }
        return dp[0];
        
    }
}