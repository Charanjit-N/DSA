
// Tabulation with space optimization 
// TC -> O(n) , SC->O(n)
class Solution {
    int robber(int[] arr){
        int n = arr.length;
        int prev1=  arr[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i > 1) pick = pick + prev2;
            int notPick =  0 + prev1;
            int curr =  Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        } 
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] arr1 =  new int[n-1];
        int[] arr2 = new int[n-1];

        int idx1 = 0;
        int idx2 = 0;

        for(int i=0;i<n;i++){
            if(i != n-1) arr1[idx1++] =  nums[i];
            if(i != 0) arr2[idx2++]  = nums[i];
        }
        
        return Math.max(robber(arr1) , robber(arr2));
    }
}