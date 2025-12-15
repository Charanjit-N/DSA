
//Optimal :  TC ->O(n), SC->O(n)
class Solution {
    public int specialTriplets(int[] nums) {
        int mod = (int)1e9 + 7 ;
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer> freq =  new HashMap<>();
        Map<Integer, Integer> runningFreq = new HashMap<>();

        for(int i=0;i<n;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        
        for(int i=0;i<n;i++){
            int target = 2*nums[i];
            int left =  runningFreq.getOrDefault(target,0);
            runningFreq.put(nums[i] , runningFreq.getOrDefault(nums[i],0)+1);
            int right = freq.getOrDefault(target,0) - runningFreq.getOrDefault(target,0);
            ans = (ans + (long)left * right ) % mod;
        }
        return (int)ans;
    }
}



// Better :TC ->O(n^2)
class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int ans =  0;
        int mod =  (int)1e9 + 7;
        for(int i=0;i<n;i++){
            int leftCnt = 0;
            for(int j=0;j<i;j++){
                if(nums[j]== 2*nums[i]) leftCnt++;
            }
            int rightCnt = 0;
            for(int j=i+1;j<n;j++){
                if(nums[j] == 2*nums[i] ) rightCnt++;
            }

            ans = (ans + (leftCnt * rightCnt) % mod) % mod;


        }
        return ans;
        
    }
}
