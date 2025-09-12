class LCM1752CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int len = nums.length;
        int c = 0;
        if(nums[0]<nums[len-1]) c++;
        for(int i=0;i<len-1;i++)
        {
           if(nums[i]>nums[i+1]) c++;
        }
        
        return c<=1 ? true : false;

    }
}