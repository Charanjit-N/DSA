// Recursion  : TC ->O(2^n) , SC->O(n) :recursion stack space
class Solution {
    int solve(int index, int prevIndex,int[] nums){
        if(index == nums.length) return 0;

        int notPick = 0 + solve(index+1,prevIndex,nums);
        int pick  = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
            pick  = 1 + solve(index+1,index,nums);
        }
        return Math.max(pick , notPick);
    }
    public int lengthOfLIS(int[] nums) {
        return solve(0,-1,nums);
    }
}


// Memoization : TC->O(nxn) , SC->O(n): recursion stack space + O(nxn):dp array
class Solution {
    int solve(int index, int prevIndex,int[] nums,int[][] dp){
        if(index == nums.length) return 0;
        
        if(dp[index][prevIndex+1]  != -1) return dp[index][prevIndex+1];

        int notPick = 0 + solve(index+1,prevIndex,nums,dp);
        int pick  = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
            pick  = 1 + solve(index+1,index,nums,dp);
        }
        return dp[index][prevIndex+1] = Math.max(pick , notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(0,-1,nums,dp);
    }
}


// Tabulation : TC->O(nxn), SC->O(nxn) : dp array
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int index = n-1;index>=0;index--){
            for(int prevIndex = index-1;prevIndex>=-1;prevIndex--){
                int notPick = 0 + dp[index+1][prevIndex+1];
                int pick  = 0;
                if(prevIndex == -1 || nums[index] > nums[prevIndex]){
                    pick  = 1 + dp[index+1][index+1];
                }
                dp[index][prevIndex+1] = Math.max(pick , notPick);
            }
        }
        return dp[0][-1+1];
    }
}

// Tabulation with space optimization: TC->O(nxn = n^2), SC->O(2n) : extra arrays.
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] cur = new int[n+1];
        for(int index = n-1;index>=0;index--){
            for(int prevIndex = index-1;prevIndex>=-1;prevIndex--){
                int notPick = 0 + next[prevIndex+1];
                int pick  = 0;
                if(prevIndex == -1 || nums[index] > nums[prevIndex]){
                    pick  = 1 + next[index+1];
                }
                cur[prevIndex+1] = Math.max(pick , notPick);
            }
            for(int x = 0;x<=n;x++){
                next[x] = cur[x];
            }
        }
        return next[-1+1];
    }
}


// Other Tabulation approach with single extra array
//  TC->O(n^2), SC->O(n) : dp array.
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = (int)-1e9;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i] , 1+dp[j]);
                }
            }
            max =  Math.max(max, dp[i]);
        }
        return max;
    }
}


// Finding Length of Longest Increasing Subsequence using Binary Search
// TC ->O(n logn), SC->O(n)
class Solution {
    // If the key present in the searhc are it will return that index if the  key not present in search area it will return the index where the element is very next greater that the key.
    int lowerBound(List<Integer> ls, int key){
        int low = 0;
        int high = ls.size() - 1;
        while(low <= high){
            int mid =  low + (high - low)/2;
            if(ls.get(mid) == key) high = mid-1;
            else if(key > ls.get(mid)) low = mid +1;
            else high = mid -1;
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i] > ls.get(ls.size()-1)){
                ls.add(nums[i]);
            }
            else{
                int ind = lowerBound(ls,nums[i]);
                ls.set(ind,nums[i]);
            }
        }
        return ls.size();
    }
}