/* Count of Subarrays having sum > k

// Divide and Conquer
TC -->O(n * logn), SC-->O(n)

*/
public class Main {
    static long count;
    static long countSubarraysGreaterThanK(int[] nums, long k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        count = 0;
        mergeSort(prefix, 0, n, k);
        return count;
    }
    static void mergeSort(long[] arr, int left, int right, long k) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, k);
        mergeSort(arr, mid + 1, right, k);

        countPairs(arr, left, mid, right, k);
        merge(arr, left, mid, right);
    }
    static void countPairs(long[] arr,int left,int mid,int right,long k) {
        int i = left;
        for (int j = mid + 1; j <= right; j++) {
            while (i <= mid && arr[i] < arr[j] - k){
                i++;
            }
            count += (i - left);
        }
    }
    static void merge(long[] arr,int left,int mid,int right) {
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
    public static void main(String[] args) {
        int[] arr = {-1, 4, -5, 6};
        long k = 0;
        System.out.println(countSubarraysGreaterThanK(arr, k));
    }
}






/*
If we Try to solve like absolute subarraysum >  k :
For absolute sum > k, it works because after sorting prefix sums, it only needs to count pairs whose difference exceeds a threshold, and the sorting preserves enough information for that particular counting strategy.

For this problem where subarray sum > k, If we do as:
    ->Compute prefix sums.
    ->Sort them.
    ->Count pairs with difference > k.
    we lose an important constraint: subarraySum(i,j)=P[j]−P[i−1]crequires (i−1)<j, That means the two prefix sums must appear in the original order.
    
    So we maintain an extra list sortedPrefixes as below, but below code Worst case TC -->O(n^2)
*/

public class Main {

    static long countSubarraysGreaterThanK(int[] nums, long k) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        ArrayList<Long> sortedPrefixes = new ArrayList<>();
        sortedPrefixes.add(0L);

        long count = 0;

        for (int j = 1; j <= n; j++) {

            long target = prefix[j] - k;

            // Count previous prefix sums < target
            int pos = lowerBound(sortedPrefixes, target);
            count += pos;

            // Insert current prefix sum in sorted order
            int insertPos = lowerBound(sortedPrefixes, prefix[j]);
            sortedPrefixes.add(insertPos, prefix[j]);
        }

        return count;
    }

    static int lowerBound(ArrayList<Long> list, long x) {
        int l = 0, r = list.size();

        while (l < r) {
            int m = l + (r - l) / 2;

            if (list.get(m) < x)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 4, -5, 6};
        int k = 0;

        System.out.println(countSubarraysGreaterThanK(arr, k));
    }
}
