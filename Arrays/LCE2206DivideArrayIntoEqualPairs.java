class LCE2206DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        // If the frequencies are odd we can pair.  
        // TC->O(n), SC->O(n)
        // int n = nums.length;
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<n;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }
        // for(int x : map.values()){
        //     if(x % 2 == 1) return false;
        // }
        // return true;
   
        // As 1<=nums[i] <= 500 : we can also use an array(size = 501) to hash
        // TC->O(n), SC->O(500)=O(1)
        int n = nums.length;
        int[] hash = new int[501];
        for(int num : nums){
            hash[num]++;
        } 
        for(int x : hash){
            if(x%2 == 1) return false;
        }
        return true;

        // Sort the array ans check if 'i' & 'i-1' (i>=1) indices have same values
        // TC->O(n*logn), SC->O(1)
        // Arrays.sort(nums);
        // int n  = nums.length;
        // for(int i=1;i<n;i+=2){
        //     if(nums[i]!=nums[i-1]) return false;
        // }
        // return true;

        // Sort the array ans check if 'i' & 'i-1' (i>=1) indices xor values becomes 0
        // Lets say nums = [2,3,4,5] xor of all (2^3^4^5)=0 but we need false : xor of all numbers = 0 wont work
        // TC->O(n*logn), SC->O(1)
        // int n = nums.length;
        // Arrays.sort(nums);
        // for(int i=1;i<n;i+=2){
        //     if((nums[i]^nums[i-1]) != 0) return false;
        // }
        // return true;
    }

}