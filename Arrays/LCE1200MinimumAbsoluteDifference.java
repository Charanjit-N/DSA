class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            minDiff = Math.min(minDiff, arr[i]-arr[i-1]);
        }
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1] == minDiff){
                List<Integer> ls = new ArrayList<>();
                ls.add(arr[i-1]);
                ls.add(arr[i]);
                ans.add(ls);
            }
        }
        return ans;

    }
}