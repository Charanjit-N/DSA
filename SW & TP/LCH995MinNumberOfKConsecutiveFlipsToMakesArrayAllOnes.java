// Brute force would be greedily if nums[i] is zero then flip all the k consecutive elements (using a loop) but the Time Complexity->O(n*k)

// TC->O(n), SC->O(n)
class LCH995MinNumberOfKConsecutiveFlipsToMakesArrayAllOnes {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] isFlipped = new int[n];
        int ans =0, flipCnt =0;
        for(int i=0;i<n;i++){
            if(i >= k){
                flipCnt -= isFlipped[i-k];
            }
            if((nums[i]==0 && flipCnt%2==0) || (nums[i]==1 && flipCnt%2==1)){
                if(i>n-k) return -1;
                ans++;
                flipCnt++;
                isFlipped[i] = 1;
            }
        }
        return ans;
    }
}

// TC->O(n), SC->O(1)
// No need to tracking which indexes are fliped instead modified the given nums array , added +2 iif flipped at that index and subtracted -2 afterwards
class LCH995MinNumberOfKConsecutiveFlipsToMakesArrayAllOnes{
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        // int[] isFlipped = new int[n];
        int ans =0, flipCnt =0;
        for(int i=0;i<n;i++){
            if(i >= k){
                if(nums[i-k]>1){
                    flipCnt --;
                    nums[i-k] -= 2;
                }
            }
            if((nums[i]==0 && flipCnt%2==0) || (nums[i]==1 && flipCnt%2==1)){
                if(i>n-k) return -1;
                else{
                    ans++;
                    flipCnt++;
                    nums[i] += 2;
                }
            }
        }
        if(nums[n-k]>1) nums[n-k]-=2;
        // System.out.println(Arrays.toString(nums));
        return ans;
    }
}