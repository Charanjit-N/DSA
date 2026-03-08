// TC --> O(n * logn +  n)
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int key = original;
        for(int i=0;i<nums.length;i++){
            if(nums[i]== key) key = 2*key;
        }
        return key;
    }
}