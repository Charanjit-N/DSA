class GFG_findAllSubsetSums {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        findSubsetSums(arr,0,0,ans);
        return ans;
    }
    
    void findSubsetSums(int[] arr, int index, int sum,  ArrayList<Integer> ans){
        if(index==arr.length){
            ans.add(sum);
            return;
        }
      
        sum+=arr[index];
        findSubsetSums(arr, index+1, sum,ans);
        sum-=arr[index];
        findSubsetSums(arr,index+1,sum,ans);
        
    }
}