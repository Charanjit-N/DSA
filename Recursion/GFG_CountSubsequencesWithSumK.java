/* Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.*/

class GFG_CountSubsequencesWithSumK {
    // Function to calculate the number of subsets with a given sum
    public int count(int[] nums, int target) {
      
        int sum =0;
        return countSubseqWithSumK(nums,0, sum,target);
        
       
    }
    int countSubseqWithSumK(int[] nums, int index, int sum ,int target){
        
        if(index==nums.length){
            if(sum==target ){
                return 1;
            }
            else{
                return 0;
            }
        }
        sum += nums[index];
        int l = countSubseqWithSumK(nums,index+1,sum,target);
        
        sum-= nums[index];
        int r  = countSubseqWithSumK(nums,index+1,sum,target);
        return l+r;
        
    }
}
