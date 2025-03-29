class LCM39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        makeCombination(candidates,0,0,target,new ArrayList<>(),res);
        // 2nd way 
        // makeCombination(candidates,0,target, new ArrayList<>(),res);
        
        return res;        
    }

    

    private void makeCombination(int[] candidates, int index, int sum, int target, List<Integer> ls,List<List<Integer>> res) {
        if(index== candidates.length){
            if(sum==target){
                res.add(new ArrayList<>(ls));
            }
            return;
        }
       if(sum<target){
        ls.add(candidates[index]);
        sum+=candidates[index];
        makeCombination(candidates,index,sum,target,ls, res);
        
        ls.remove(ls.size() - 1);
        sum-=candidates[index];
       }
        makeCombination(candidates,index+1,sum,target,ls, res);
    }   
    // 2nd way   
    // private void makeCombination(int[] candidates, int index, int target, List<Integer> ls,List<List<Integer>> res) {
    //     if(index== candidates.length){
    //         if(target ==0){
    //             res.add(new ArrayList<>(ls));
    //         }
    //         return;
    //     }
    //    if(candidates[index]<=target){
    //     ls.add(candidates[index]);
    //     makeCombination(candidates,index,target-candidates[index],ls, res);
        
    //     ls.remove(ls.size() - 1);
    //    }
    //     makeCombination(candidates,index+1,target,ls, res);
    // } 
}

  
