class LCE268MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int allXor = 0;
        for(int i=0;i<=n;i++)
        {
            allXor  = allXor ^ i;
        }
        for(int i=0;i<n;i++)
        {
            allXor  = allXor ^ nums[i];
        }

        return allXor;
    }
}