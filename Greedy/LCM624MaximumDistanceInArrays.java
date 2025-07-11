 
class LCM624MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        
        //T.C -> O(n) , SC->O(1)
        int m = arrays.size();  // no.of lists in the list arrays
        int pastMin = arrays.get(0).get(0);
        int pastMax = arrays.get(0).get(arrays.get(0).size()-1);
        int ans = 0;
        for(int i=1;i<m;i++){
            List<Integer> ls = arrays.get(i);
            int currMin = ls.get(0);
            int currMax = ls.get(ls.size()-1);

            ans = Math.max(ans,Math.max(currMax-pastMin , pastMax - currMin));

            pastMin = Math.min(pastMin,currMin );
            pastMax = Math.max(pastMax,currMax);
        }
        return ans;
        
        
    }
}