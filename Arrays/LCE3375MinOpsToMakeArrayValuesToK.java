
// Sorting : TC->O(n*logn), SC->O(1)
class LCE3375MinOpsToMakeArrayValuesToK {
    public int minOperations(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        if(nums[0] < k ) return -1;

        int cur = nums[len-1];
        int ans = cur > k ? 1 : 0;
        for(int i=len-2;i>=0;i--){
            if(nums[i]<=k) break;
            if(nums[i]!=cur){
                ans++;
                cur = nums[i];
            }
        }
        return ans;

        
    }
}

// Using hash map
//TC->O(n), SC->O(n)
class LCE3375MinOpsToMakeArrayValuesToK {
    public int minOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            if(x < k) return -1;
            else if(x > k) map.put(x, map.getOrDefault(x,0)+1);
        }
        return map.size();
    
    }
}
// As 1 <= nums[i] <= 100
// Using BitSet class in java
// TC-> O(n), SC->O(max(nums));
class LCE3375MinOpsToMakeArrayValuesToK {
    public int minOperations(int[] nums, int k) {
        int mini = Integer.MAX_VALUE;
        for (int i : nums) mini = Math.min(mini, i);
        if (mini < k) return -1;

        BitSet st = new BitSet(101);
        for (int i : nums) if (i > k) st.set(i);

        return st.cardinality();
    }
}