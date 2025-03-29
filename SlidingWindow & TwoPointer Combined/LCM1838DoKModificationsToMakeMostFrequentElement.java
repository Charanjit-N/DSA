
// Sliding window approach after sorting

class LCM1838DoKModificationsToMakeMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        // TC-> O(n*logn) + O(2*n) = (approx) O(n*logn)
        // Sc->O(1)
        int len = nums.length;
        Arrays.sort(nums);       // O(n*logn)
        int l=0,r=0;
        int total =0, ans=0;
        while(r<len){                 // O(2*n)
            total = total + nums[r];
            while(nums[r]*(r-l+1) - total >  k){
                total =  total - nums[l];
                l++;
            }
            ans = Math.max(ans, r-l+1 );
            r++;  
        }
        
        return ans;
        
    }

}

// Using sorting and Binary Search 

// TC-> O(n*logn) + O(n*logn) = (approx) O(n*logn) 
class LCM1838DoKModificationsToMakeMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        long[] prefixSum = new long[len];
        prefixSum[0]= nums[0];
        for(int i=1;i<len;i++){
            prefixSum[i]=prefixSum[i-1] + nums[i];
        }

        int maxFreq = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int freq = binarySearch(nums,i,k,prefixSum);
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
        
    }

    int binarySearch(int[] nums, int index,int k, long[] prefixSum){
        int low=0,high = index;
        int ans = index;
        while(low<=high){
            int mid = low + (high-low)/2;
            long modifiedSum = (long) (index - mid + 1) *  nums[index];
            long originalSum =prefixSum[index] - prefixSum[mid] + nums[mid];
            if(modifiedSum - originalSum <= k){
                ans = mid;
                high =  mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return (index-ans+1);  // window size.
    }
}