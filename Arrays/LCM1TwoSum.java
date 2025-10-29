// TC ->O(n), SC->O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =  new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int second = target - nums[i];
            if(map.containsKey(second))
            {
                return new int[] {i, map.get(second)};
            }
            map.put(nums[i],i);
        }
  
      return new int[]{};
    }
}


