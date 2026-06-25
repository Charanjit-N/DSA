// Optimal : use presum map lookup. TC-->O(n), SC-->O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int preSum =0;
        int cnt = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum +=nums[i];
            int rem = preSum - k;
            cnt+=map.getOrDefault(rem,0);
            map.put(preSum,map.getOrDefault(preSum,0)+1);

        }
        return cnt;
        
    }
}


// TC --> O(n^2)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k) cnt++;
            }
        }
        return cnt;
        
    }
}