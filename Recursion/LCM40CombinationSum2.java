class LCM40CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(candidates);
       findCombSum2(candidates,0,target,new ArrayList<>(), res);
       return res;
    }
    void findCombSum2(int[] candidates, int index, int target, List<Integer> ls, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;

            ls.add(candidates[i]);
            findCombSum2(candidates, i+1, target-candidates[i], ls, res);
            ls.remove(ls.size()-1);
        }

    }
}