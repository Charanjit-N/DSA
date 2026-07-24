/*
idea : xor of lets say 3 numbers will not be > the lowest power of 2 that is > the max number among those numbers
*/

// TC --> O(n^2 + n*max(nums)) , SC-->O(max(nums))
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int x : nums){
            max = Math.max(max, x);
        }
        int k = 1;
        while( k <= max){
            k = k << 1;
        }
        // marking all possible duplets 
        boolean[] s = new boolean[k];
        for(int i=0;i<n;i++){
            for(int j = i;j<n;j++){
                s[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] t = new boolean[k];
        for(int i=0;i<k;i++){
            if(s[i] == false) continue;
            for(int x : nums){
                t[i ^ x] = true;
            }
        }

        int cnt = 0;
        for(boolean x : t){
            if(x == true) cnt++;
        }
        return cnt;
    }
}


// TC --> O(n*max(nums)) , SC-->O(max(nums))
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int k = 1;
        while (k <= max) {
            k = k << 1;
        }
        boolean[] one = new boolean[k];
        boolean[] two = new boolean[k];
        boolean[] three = new boolean[k];
        for (int x : nums) {
            one[x] = true;
            for (int i = 0; i < k; i++) {
                if (one[i]) {
                    two[i ^ x] = true;
                }
            }
        }
        for (int x : nums) {
            for (int i = 0; i < k; i++) {
                if (two[i]) {
                    three[i ^ x] = true;
                }
            }
        }
        int ans = 0;
        for (boolean b : three) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }
}