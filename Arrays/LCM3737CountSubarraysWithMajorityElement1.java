// Optimal : Divide and Conquer (TC-->O(n*logn) , SC-->O(n))
class Solution {
    long count;
    void mergeSort(long[] arr, int left, int right, long k) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, k);
        mergeSort(arr, mid + 1, right, k);

        countPairs(arr, left, mid, right, k);
        merge(arr, left, mid, right);
    }

    

    void countPairs(long[] arr,int left,int mid,int right,long k) {
        int i = left;
        for (int j = mid + 1; j <= right; j++) {
            while (i <= mid && arr[i] < arr[j] - k)
                i++;
            count += (i - left);
        }
    }

    void merge(long[] arr,int left,int mid,int right) {
        long[] temp = new long[right - left + 1];

        int i = left;
        int j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[idx++] = arr[i++];
            else
                temp[idx++] = arr[j++];
        }

        while (i <= mid)
            temp[idx++] = arr[i++];

        while (j <= right)
            temp[idx++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }


    int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == target) nums[i] = 1;
            else nums[i] = -1;
        }
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        count = 0;
        mergeSort(prefix, 0, n, 0);
        return (int)count;
    }
}


// Brute Force : TC -->O(n^2)
// class Solution{
//      int countMajoritySubarrays(int[] nums, int target) {
//         int n = nums.length;
//         int ans = 0;
//         for(int i=0;i<n;i++){
//             int cnt = 0;
//             for(int j=i;j<n;j++){
//                 if(nums[j] == target){
//                     cnt++;
//                 }
//                 if(cnt > (j-i+1)/2){
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }


