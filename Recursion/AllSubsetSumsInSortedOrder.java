
// Find all subset sums and answer list should have elements in increasing order

// Sol : Sorting(xlogx) the answer list at last 


// TC->  O(2^n + 2^n log(2^n)) (approx)
class AllSubsetSumsInSortedOrder {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        findSubsetSums(arr,0,0,ans);
        Collections.sort(ans);
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