//TC -->O(n), SC-->O(n)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int rem = 0;
        for(int i=0;i<n;i++){
            rem = (2 * rem) % 5;
            rem = (rem + nums[i]) % 5;
            if(rem ==0 ) ans.add(true);
            else ans.add(false);
        }
        return ans;
        
    }
}