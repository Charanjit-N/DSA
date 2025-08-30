//Optimal :  TC ->O(n*logn) + O(q * logn)  q->len(queries) , n->len(nums)
class Solution {
    int findFirstGreaterElementIndex(int[] nums, int q){ // UpperBOund
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low+(high -low)/2;
            if(nums[mid] <= q) low = mid+1;
            else{
                ans = mid;
                high = mid-1;
            }
           
        }
        return ans;
    }
    public List<Long> minOperations(int[] nums, int[] queries) {
        int len =  queries.length;
        int n = nums.length;
        Arrays.sort(nums);
        long[] preSum = new long[n];
        preSum[0] =  nums[0];
        for(int i=1;i<n;i++){
            preSum[i] =  preSum[i-1]+nums[i];
        }
       
        List<Long> ans = new ArrayList<>();
        for(int q : queries){
            int idx = findFirstGreaterElementIndex(nums, q);
            long moves = 0;
           

            if (idx == 0) {
                moves = preSum[n - 1] - (long) n * q; 
            } else {
                long left = (long) idx * q - preSum[idx - 1];  
                long right = (preSum[n - 1] - preSum[idx - 1]) - (long) (n - idx) * q;
                moves = left + right;
            }
            ans.add(moves);
        }
        return ans;
    }
}


// Brute TC->O(n*q)
class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int q =  queries.length;
        List<Long> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            long cnt = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[j] != queries[i]){
                    cnt+= Math.abs(queries[i]-nums[j]);
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}