// Optimal Solution if Array has -ve numbers as well
//Time: O(n log n) (because each insertion / ceilingEntry in TreeMap is O(log n))
// Space: O(n) for the prefix sums in TreeMap

public class LongesSolutiontSubarraySumLEK {
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        int maxLen = 0;

        // TreeMap<PrefixSumValue, EarliestIndex>
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, -1);  

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            // find the smallest prefixSum >= prefixSum - k
            Long target = prefixSum - k;
            Map.Entry<Long, Integer> entry = map.ceilingEntry(target);
            if (entry != null) {
                int startIndex = entry.getValue();
                int len = i- startIndex;
                maxLen = Math.max(maxLen, len);
            }

            // store earliest index of this prefixSum
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i );
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, -1, 2, -3, 2, 1};
        int k1 = 3;
        System.out.println("Longest length = " + longestSubarray(arr1, k1)); // Expected: 5

        int[] arr2 = {2, -1, 2};
        int k2 = 3;
        System.out.println("Longest length = " + longestSubarray(arr2, k2)); // Expected: 3

        int[] arr3 = {5, -2, 3, -1, 2};
        int k3 = 4;
        System.out.println("Longest length = " + longestSubarray(arr3, k3)); // Expected: 4
    }
}


// If array have non-negative numbers then we can solve using Sliding window in TC->O(2*n)
public class Solution {
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        long prefixSum = 0;
        int maxLen = 0;

        for (int r = 0; r < n; r++) {
            prefixSum += nums[r];

            while (l <= r && prefixSum > k ) {
                prefixSum -= nums[l];
                l++;
            }

            
            if (prefixSum <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        return maxLen;
    }
}