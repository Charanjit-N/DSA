//  TC->O(n^2 + 2*LDS length), SC->O(2n + 2*LDS length)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] prev = new int[n];
        int lastIndex = 0;
        int maxLen = (int)-1e9;
        for(int i=0;i<n;i++){
            prev[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] ==0 && 1+dp[j] > dp[i]){
                    dp[i] = 1+dp[j] ;
                    prev[i] = j;
                }
            }
           if(dp[i] > maxLen){
            maxLen = dp[i];
            lastIndex = i;
           }
        }
        // maxLen = Length of the Largest Divisible Subset
        int[] lds =  new int[maxLen];
        lds[maxLen-1] =  nums[lastIndex];
        int index = maxLen-2;
        while(prev[lastIndex]  != lastIndex){
            lastIndex =  prev[lastIndex];
            lds[index] = nums[lastIndex];
            index--;
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int x : lds) ans.add(x);
        return ans;
    }
}