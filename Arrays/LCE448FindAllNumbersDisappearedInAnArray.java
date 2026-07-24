// TC --> O(n) , SC-->O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        for(int x : nums){
            int index = Math.abs(x) - 1;
            if(nums[index] > 0){
                nums[index]= -nums[index];
            }
            
        }
        for(int i =0;i<n;i++){
            if(nums[i] > 0) ls.add(i+1);
        }
        return ls;
    }
}


