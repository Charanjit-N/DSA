

/*
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.

To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, provided it exists. Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
*/



// Recursion
// class FrogJump {
//     static int jump(int index,int[] heights){
//         if(index ==0) return 0;
//         int oneStep =  jump(index-1, heights) + Math.abs(heights[index]-heights[index-1]);
//         int twoStep = Integer.MAX_VALUE;
//         if(index>1){
//             twoStep = jump(index-2, heights) + Math.abs(heights[index]-heights[index-2]); 
//         }
//         return Math.min(oneStep, twoStep);
//     }
//     public static void main(String[] args){
//         int[] heights = {7,5,1,2,6};
//         System.out.println(jump(heights.length-1,heights));
//     }
// }


// Memoization 
// class FrogJump {
//     static int jump(int index,int[] heights, int[] dp){
//         if(index ==0) return 0;
//         if(dp[index] != -1) return dp[index];
//         int oneStep =  jump(index-1, heights,dp) + Math.abs(heights[index]-heights[index-1]);
//         int twoStep = Integer.MAX_VALUE;
//         if(index>1){
//             twoStep = jump(index-2, heights,dp) + Math.abs(heights[index]-heights[index-2]); 
//         }
//         return dp[index] = Math.min(oneStep, twoStep);
//     }
//     public static void main(String[] args){
//         int[] heights = {7,5,1,2,6};
//         int n = heights.length;
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         System.out.println(jump(n-1,heights,dp));
//     }
// }


// Tabulation
// class FrogJump {
//     public static void main(String[] args){
//         int[] heights = {7,5,1,2,6};
//         int n = heights.length;
//         int[] dp = new int[n];
//         dp[0] = 0;
//         for(int i =1;i<n;i++){
//             int oneStep = dp[i-1] + Math.abs(heights[i]-heights[i-1]); 
//             int twoStep = Integer.MAX_VALUE;
//             if(i>1 ){
//                 twoStep = dp[i-2] + Math.abs(heights[i]-heights[i-2]); 
//             }

//             dp[i] = Math.min(oneStep, twoStep);
//         }
//         System.out.println(dp[n-1]);

//     }
// }

// Tabulation - space optimize

class FrogJump {
    public static void main(String[] args){
        int[] heights = {7,5,1,2,6};
        int n = heights.length;
        int prev1 = 0;
        int prev2 = 0;
        for(int i =1;i<n;i++){
            int oneStep = prev1 + Math.abs(heights[i]-heights[i-1]); 
            int twoStep = Integer.MAX_VALUE;
            if(i>1 ){
                twoStep = prev2 + Math.abs(heights[i]-heights[i-2]); 
            }
            int curr = Math.min(oneStep, twoStep);
            prev2 = prev1;
            prev1 = curr;
        }
        System.out.println(prev1);

    }
}