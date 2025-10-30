// TC ->O(n)
class Solution {
    public int minNumberOperations(int[] target) {
        int ops = target[0]; 
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                ops += target[i] - target[i - 1];
            }
        }
        return ops;
    }
}

// Brute Force : O(n^2)
class Solution {
    int getLongSubArrayWithNoZero(int[] nums){
        int n = nums.length;
        int max =  0;
        int L = 0;
        int R = 0;
        int i = 0;
        for(int j=0;j<n;j++){
            if(nums[j] == 0){
                if(j != n-1) i = j+1;
                continue;
            }
            if(j-i+1 > max){
                max = j-i+1;
                R = j;
                L = i;
            }
        }   
        for(int j=L;j<=R;j++){
            nums[j]--;
        }
        return max;
    }
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int ops = 0;
        while(getLongSubArrayWithNoZero(target) > 0){
           
            ops++;
        }
        return ops;
    }
}