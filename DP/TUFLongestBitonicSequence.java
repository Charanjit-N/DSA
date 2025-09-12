// Tabulation approoach 
// TC->O(n^2), SC->O(n) : dp arrays.
class Solution {
    public int LongestBitonicSequence(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] <arr[i]){
                    dp1[i] = Math.max(dp1[i] , 1+dp1[j]);
                }
            }
            
        }
        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[j] < arr[i]){
                    dp2[i] = Math.max(dp2[i] , 1+dp2[j]);
                }
            }
            
        }
        int max = (int)-1e9;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }
        return max;
    }
}

