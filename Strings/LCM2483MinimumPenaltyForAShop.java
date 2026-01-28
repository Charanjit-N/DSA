class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefixSumY = new int[n];
        int[] suffixSumY = new int[n];
        prefixSumY[0] = (customers.charAt(0) == 'Y') ? 1 : 0;
        for(int i=1;i<n;i++){
            prefixSumY[i] = prefixSumY[i-1] + ((customers.charAt(i) == 'Y') ? 1 : 0);
        }

        suffixSumY[n-1] = (customers.charAt(n-1) == 'Y') ? 1 : 0;
        for(int i=n-2;i>=0;i--){
            suffixSumY[i] = suffixSumY[i+1] + ((customers.charAt(i) == 'Y') ? 1 : 0); 
        }

        int minPenalty = (int)1e9;
        int ans = -1;
        


        for(int j=0;j<=n;j++){
            int preY =  (j > 0) ? prefixSumY[j-1] : 0;
            int preN = j - preY;
            int suffY = (j == n) ? 0  : suffixSumY[j];
            int penalty  = preN +  suffY;
            if(penalty < minPenalty){
                ans = j;
                minPenalty = penalty;
            }
            
        }
        return ans;
        
    }
}