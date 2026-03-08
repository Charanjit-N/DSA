
// TC -> O( n^2 * log(Min(a,b)))
class Solution {
    int gcd(int a, int b) {     // TC --> log(Min(a,b))
        return b == 0 ? a : gcd(b, a % b);
    }
    public int minOperations(int[] nums) {
        int len = nums.length;
        int onesCnt = 0;
        for(int i=0;i<len;i++){
            if(nums[i] == 1) onesCnt++;
        }
        if(onesCnt != 0) {
            return len - onesCnt;
        }
        

        int ops = len;
        for(int start=0;start<len-1 ;start++){
            int cumGcd = nums[start];
            for(int i = start;i < len-1 ; i++){
                cumGcd = gcd(cumGcd, nums[i+1]);
                if(cumGcd == 1){
                    ops = Math.min(ops,  i+1-start); 
                    break;
                }
            }
            
        }

        if(ops != len) return ops +  len - 1;
        return -1;
    }
}