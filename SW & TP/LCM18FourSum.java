// TC ->O(n^3)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if (j != (i+1) && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;
                while (left<right) {
                     // we are doing sum like this to avoid overflow of int capacity
                    long sum = nums[i];  
                    sum +=nums[j];
                    sum += nums[left];
                    sum +=nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[left],nums[right]);
                        ans.add(temp);
                        left++;
                        right--;
                        //skip the duplicates for unique nums[i],nums[j],nums[k] pair.
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return ans;
    }
}