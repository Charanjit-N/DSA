
// Print Any Only one subsequence having sum==k 
// TC-> O(2^n)
class PrintOnlyOneSubsequenceWithSumK{
    // Function to calculate the number of subsets with a given sum
    public void subsequencesWithSumK(int[] nums, int target) {
      
        List<Integer> ls = new ArrayList<>();
        int sum =0;
        findOnlyOneSubsequenceWithSumK(nums,0,sum,ls,target);
    }
    
    boolean findOnlyOneSubsequenceWithSumK(int[] nums, int index, int sum , List<Integer> ls,int target){
        /*we can also use a global flag variable but not recommended uusing global variables in an interview
                if(index==nums.length){
                    if(sum==target  && flag == false){  // take a global variable flag(boolean)
                        System.out.println(ls);
                        flag = true;
                        return;
                    }
                    else{
                        return false;
                    }
                }
         */
        if(index==nums.length){
            if(sum==target ){
                System.out.println(ls);
                return true
            }
            else{
                return false;
            }
        }
        ls.add(nums[index]);
        sum += nums[index];
        if(findOnlyOneSubsequenceWithSumK(nums,index+1,sum,ls,target) == true) return true;
        
        ls.remove(ls.size()-1);
        sum-= nums[index];
        if(findOnlyOneSubsequenceWithSumK(nums,index+1,sum,ls,target) == true) return true;
        
        return false;
    }
}