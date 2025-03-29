//TC-> approx O(n) , SC->O(1) in place

class LCM31NextPermutation {
    void reverse(int[] nums,int left,int right)
    {
        while(left<right)
        {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        
        int n= nums.length;
        int dipIndex = -1;
        for(int i=n-1;i>0;i--)
        {  
            if(nums[i]>nums[i-1])
            {
                dipIndex = i-1;
                break;
            }
        }
        
        if(dipIndex == -1) { reverse(nums,0,n-1);}

        else {
            
            for(int i=n-1;i>dipIndex;i--)
            {
                if((nums[i] > nums[dipIndex]))
                {
                     int temp = nums[dipIndex];
                     nums[dipIndex] = nums[i];
                     nums[i] = temp;
                     break;
                }
            }
            
            reverse(nums,dipIndex+1,n-1); 
        }
    }
}