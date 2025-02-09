/*You are given an array nums consisting of n prime integers.

You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].

Additionally, you must minimize each value of ans[i] in the resulting array.

If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.*/ 

class LCM3315ConstructTheMinimumBitwiseArrayII{
    public int[] minBitwiseArray(List<Integer> nums) {
        // Optimal : TC->O(n*30) = (approx) O(n) , SC->O(n) {for returing the answer}
        int len = nums.size();
        int ans[] = new int[len];
        for(int i=0;i<len;i++){
            if(nums.get(i)==2){
                ans[i] = -1;
                continue;
            } 
            for(int x = 1;x<31;x++){
                if( ( nums.get(i) & (1 << x) ) != 0) { continue;}
                else{
                    ans[i] = nums.get(i) ^ (1<<(x-1));  // ans[i] = nums.get(i) & (~(1<<(x-1)));
                    break;
                }
            }
        }
        return ans;

        // Brute Force (TLE) : TC->O(n*(10^9)) , SC->O(n) {for returing the answer}
        // int len = nums.size();
        // int[] res = new int[len];
        // Arrays.fill(res,-1);
        // for(int i=0;i<len;i++){
        //     for(int x=0;x<nums.get(i);x++){
        //         if((x | (x+1)) == nums.get(i)){
        //             res[i] =x;
        //             break;
        //         }
        //     }
        // }
        // return res;
        
    }
}