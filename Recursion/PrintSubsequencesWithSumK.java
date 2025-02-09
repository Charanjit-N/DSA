class PrintSubsequencesWithSumK{
    // Function to calculate the number of subsets with a given sum
    public void subsequencesWithSumK(int[] nums, int target) {
      
        List<Integer> ls = new ArrayList<>();
        int sum =0;
        findSubsequencesWithSumK(nums,0,sum,ls,target);
    
        
    }
    
    void findSubsequencesWithSumK(int[] nums, int index, int sum , List<Integer> ls,int target){
        
        if(index==nums.length){
            if(sum==target ){
                System.out.println(ls);
            }
            return;
        }
        ls.add(nums[index]);
        sum += nums[index];
        findSubsequencesWithSumK(nums,index+1,sum,ls,target);
        
        ls.remove(ls.size()-1);
        sum-= nums[index];
        findSubsequencesWithSumK(nums,index+1,sum,ls,target);
    }
}