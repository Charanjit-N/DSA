/* TC -->O(n) , SC-->O(n)
A subarry [l...r] = PreSum[r] - preSum[l-1] : subarray array sum can be represneted as prefix sum difference
we want subarrays having |preSum[j] - preSum[i]| > k 
as we sort prefixSum array => preSum[j] - preSum[i] > k
                           => preSum[j] > preSum[i] + k

for every preSum[j]  we find the preSum having sum > preSum[i] + k using upperBound(binary search)
*/
 class Solution{
    int upperBound(int[] a, int element){
        int n = a.length;
        int low = 0, high = n-1;
        int ub = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(a[mid] > element){
                ub = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        System.out.println(element +" "+ub);
        return ub;
        
    }
    int countSubarraysAbsoluteSumGreterThanK(int[] arr, int k){
        int n = arr.length;
        int[] preSum = new int[n];
        // int[] preSum = {-2,-1,3,4};
        
        preSum[0] = arr[0];
        int cnt = 0;
        if(preSum[0] > k || preSum[0] < -1*k){
            cnt++;
        }
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + arr[i];
            if(preSum[i] > k || preSum[i] < -1*k){
                cnt++;
            }
        }
        Arrays.sort(preSum);
       
        for(int i=0;i<n;i++){
            cnt += (n - upperBound(preSum,preSum[i]+k) );
        }
        return cnt
    }
}