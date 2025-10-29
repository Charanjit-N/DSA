// TC ->O(Q) , Q --> # queries, SC ->O(N)
class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums =  nums;
        for(int i=1;i<nums.length;i++){
            nums[i] +=  nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        int x=0;
        x = (left>=1) ?  nums[left-1] : 0;
        return nums[right]-x;
        
    }
}

