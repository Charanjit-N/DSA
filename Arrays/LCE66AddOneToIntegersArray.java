class LCE66AddOneToIntegersArray {
    // TC->O(2n)=O(n)(approximation) , SC->O(n) {used to return the answer not to solve the problem}
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        int ansSize = n+1;
        for(int i=0;i<n;i++){
            if(digits[i]!=9){
                ansSize = n;
                break;
            }
        }
        int[] ans = new int[ansSize];
        if(ansSize == n+1){
            ans[0] = 1;
            return ans;
        }
        for(int i=n-1;i>=0;i--){
            ans[i]= (digits[i]+carry) %10;
            carry = (digits[i]+carry) / 10;
        }
        return ans;
        
    
        
    }
}