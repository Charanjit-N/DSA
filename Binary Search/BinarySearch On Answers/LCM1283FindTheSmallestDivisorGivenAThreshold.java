// Optimal : Binary Search on the outer loop 
//T.C --> O(n * log(max array element))
class Solution {
    int resultSum(int[] arr,int divisor){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += Math.ceil((double)arr[i]/divisor);  
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
            int n = nums.length;
            if(n>threshold) return -1;
            int max = 0;
            for(int i=0;i<n;i++){    
                if(nums[i]>max) max = nums[i];
            }
            int low = 1,high = max;
            // Binnary Searching
            while(low<=high){
                int mid = low+(high-low)/2;
                if(resultSum(nums,mid)<=threshold) high = mid-1;
                else low = mid+1;
            }
            return low;
    }
}