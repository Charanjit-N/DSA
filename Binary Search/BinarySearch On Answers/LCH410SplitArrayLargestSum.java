// TC->O(n * log(sum of elements in arr - max element in arr))
class Solution {
    int countSubarrays(int[] nums, int maxSum){
        int cnt = 1; 
        int subarraySum = 0;
        for(int i=0;i<nums.length;i++){
            if(subarraySum + nums[i] > maxSum){
                cnt++;
                subarraySum = nums[i];
            }
            else{
                subarraySum += nums[i];
            }
        }
        return cnt;

    }
    public int splitArray(int[] nums, int k) {
        int low = nums[0],high = 0;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        // Binary search 
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int cnt = countSubarrays(nums,mid);
            if(cnt > k)  low=mid+1;
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}