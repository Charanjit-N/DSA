/*
Optimal 1: Greedy 
TC->O(n) , SC->O(1)
Greedily As we keep traversing the array we store,
The value of the largest element we've meet so far.
The largest difference between any two elements we've found so far.
Using these two we can calculate the largest triplet value and return it.
*/


class LCE2873MaxValueOfAnOrderedTriplet1 {
    public long maximumTripletValue(int[] nums) {
        long maxTripletValue = 0, maxEle = 0, maxDiff = 0;
        for (int num : nums) {
            maxTripletValue = Math.max(maxTripletValue, maxDiff * num);
            maxDiff = Math.max(maxDiff, maxEle - num);
            maxEle = Math.max(maxEle, num);
        }
        return maxTripletValue;
    }
}

/*
Optimal 2:  Prefix Max, Suffix Max
TC->O(n), SC->O(1)
we vary the index j for the index tuple (i, j, k) and maximize the value
Let P, S be the arrays having prefix max, suffix max for the given array nums
p[x] is the max from 0 to x-1 indices. 
s[x]  is the max from x+1 to n-1 indices.
we can find the answer maxVal=max(maxVal, (long)(P[i]-nums[i])*S[i]) jterating from i=1 to n-2
*/
class LCE2873MaxValueOfAnOrderedTriplet1 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = Long.MIN_VALUE;
        int[] p = new int[n];
        int[] s = new int[n];
        for(int i=1;i<n;i++){
            p[i] = Math.max(p[i-1],nums[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            s[i] = Math.max(s[i+1],nums[i+1]);
        }

        for(int i=1;i<=n-2;i++){
            maxVal = Math.max(maxVal, (long)(p[i]-nums[i])*s[i]);
        }
        return maxVal<0 ? 0 :maxVal;
    }
}


// Brute Force: TC->O(n^3) SC->O(1)
class LCE2873MaxValueOfAnOrderedTriplet1 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    max = Math.max(max,(long)(nums[i]-nums[j])*nums[k]);
                }
            }
        }
        System.out.println(max);
        return max<0 ? 0 : max;
    }
}