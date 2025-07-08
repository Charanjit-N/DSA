


// Other Tabulation approach
//  TC->O(n^2 + LIS length), SC->O(2n + LIS length)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] prev = new int[n];
        int lastIndex = 0;
        int maxLen = (int)-1e9;
        for(int i=0;i<n;i++){
            prev[i] = i;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i] && 1+dp[j] > dp[i]){
                    dp[i] = 1+dp[j] ;
                    prev[i] = j;
                }
            }
           if(dp[i] > maxLen){
            maxLen = dp[i];
            lastIndex = i;
           }
        }
        int[] lis =  new int[maxLen];
        lis[maxLen-1] =  nums[lastIndex];
        int index = maxLen-2;
        while(prev[lastIndex]  != lastIndex){
            lastIndex =  prev[lastIndex];
            lis[index] = nums[lastIndex];
            index--;
        }
        System.out.println(Arrays.toString(lis));
        return maxLen;
    }
}


// Recursion  : TC ->O(2^n) , SC->O(n) :recursion stack space
class Solution {
    int solve(int index, int prevIndex,int[] nums,List<Integer> ls,List<Integer> best){
        if(index == nums.length){
            if(ls.size() >  best.size()){
                best.clear();
                best.addAll(ls);
            }
            return 0;
        }

        int notPick = 0 + solve(index+1,prevIndex,nums,ls,best);
        int pick  = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
            ls.add(nums[index]);
            pick  = 1 + solve(index+1,index,nums,ls,best);
            ls.remove(ls.size()-1);
            
        }
        return Math.max(pick , notPick);
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        List<Integer> best = new ArrayList<>();
        int ans = solve(0,-1,nums,ls,best);
        System.out.println(best);
        return ans;
        
    }
}