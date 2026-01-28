// TC -->O(n)
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
       
        int i= n-1;
        for( ;i>=0;i--){
            if(digits[i] != 9) break;
            if(digits[i] == 9) digits[i] = 0;
        }
        if(i == -1){
            int[] ans = new int[n+1];
            ans[0] = 1;
            return ans;
        }else{
            digits[i]++;
            return digits;
        }
        

        
    }
}