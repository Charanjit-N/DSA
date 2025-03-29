class LCE3289FindTheTwoRepeatedNumbers {
    public int[] getSneakyNumbers(int[] nums) {

        // Optimal(Using BitManipulation) : TC->O(n) , SC->O(2) = (approx)O(1)
        int n = nums.length;
        int xor = 0; 
        for(int i=0;i<n;i++){
            xor ^= nums[i];
            if(i<= (n-3)){
                xor ^= i;
            }
        }
        
        int xor_rmsb = xor ^ (xor & (xor-1));

        int b0=0, b1=0;

        for(int i=0;i<n-2;i++){
            if( (i & xor_rmsb) != 0) b1 ^= i;
            else b0 ^= i;
        }

        for(int i=0;i<n;i++){
            if( (nums[i] & xor_rmsb) != 0) b1 ^= nums[i];
            else b0 ^= nums[i];
        }

        return new int[]{b0, b1};

        
    }
}