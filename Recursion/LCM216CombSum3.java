
/*Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order. */


class LCM216CombSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res= new ArrayList<>();
        int nums[] = new int[]{1,2,3,4,5,6,7,8,9};
        findCombs(nums,k,0,n,new ArrayList<>(),res);
        return res;
    }
    void findCombs(int[] nums, int k , int index, int target, List<Integer> ls, List<List<Integer>> res){
        if(k==0 || index == nums.length){
            if(k==0 && target==0) res.add(new ArrayList<>(ls));
            return;
        }
        if(nums[index]<=target){
            ls.add(nums[index]); k--;
            findCombs(nums,k,index+1,(target-nums[index]),ls,res);
            ls.remove(ls.size()-1); k++;
        }
        findCombs(nums,k,index+1,target,ls,res);
    }
}