
// Array has duplicate elements, generate all unique sub sequences

class LCM90Subsets2 {
    public List<List<Integer>> generateAllSubsetsWhenArrayHasDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(nums,0,new ArrayList<>(), res);
        return res;
    }
    void findSubsets(int[] nums, int index,List<Integer> ls, List<List<Integer>> res){
        res.add(new ArrayList<>(ls));
        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            ls.add(nums[i]);
            findSubsets(nums,i+1,ls, res);
            ls.remove(ls.size()-1);
        }
    }

        
    
}