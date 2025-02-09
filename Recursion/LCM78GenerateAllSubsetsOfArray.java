class LCM78GenerateAllSubsetsOfArray {
    private void createSubset(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        createSubset(nums, index + 1, res, subset);

        subset.remove(subset.size() - 1);
        createSubset(nums, index + 1, res, subset);
    }  
    public List<List<Integer>> subsets(int[] nums) {
        // Approach 1 : Using Recursion (Backtracking)
        // TC->O(2^n) 
        // SC->O(n + n + n*(2^n)) = (approx) O(n*(2^n)) {n-> recursion stack space ; (approx)n->list "ls" (reusing same list all the time) ; n*(2^n)-> list "res" to return the output }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        createSubset(nums, 0, res, subset);
        return res;        
   

    // Approach 2
    // With the help of Bit Manipulation technique 
    // TC-> O(n * (2^n)) , SC->O(n * (2^n))
    // int len = nums.length;
    //     int totalSubsets = 1<<len;
    //     List<List<Integer>> ans = new ArrayList<>();
    //     for(int x=0;x<totalSubsets;x++)
    //     {
    //         ArrayList<Integer> ls = new ArrayList<>();
    //         for(int i=0;i<len;i++)
    //         {
    //             if((x&(1<<i)) > 0) ls.add(nums[i]);
    //         }
    //         ans.add(ls);

    //     }
    //     return ans;
    }
}