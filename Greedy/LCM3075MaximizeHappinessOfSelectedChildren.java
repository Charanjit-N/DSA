// TC ->O(n * logn)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        int left = 0;
        int right = n-1;
        while(left <  right){
            happiness[left] =  happiness[left] + happiness[right] - (happiness[right] =  happiness[left]);
            left++;
            right--;
        }
        
        long maxSum = 0;
        int i = 0;
        int decVal = 0;
        while(k > 0 && i<n){
            int val =  happiness[i] - decVal;

            if(val > 0){
                maxSum += val;
            }else{
                break;
            }
            decVal++;
            i++;
            k--;
        }
        return maxSum;
        
    }
}