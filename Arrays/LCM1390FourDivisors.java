// TC -> O(n * sqrt(m))
class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int x : nums){
            int sum = 0;
            int cnt = 0;
            double r =  Math.sqrt(x);
            if(x<6) continue;
            for(int i=1;i<=r;i++){
                if(x%i==0){
                    cnt+= ((double)i!=r) ? 2 : 1;
                    sum += ((double)i!=r)? (i + (x/i)) : i;
                }
            }
            if(cnt==4){
                ans += sum;
            }
            
        }
        return ans;
    }
}