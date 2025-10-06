class Solution {
    // Optimal :  O(n)
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1;
        int maxWater = 0;
        while(left<right){
            int currWater = (right-left)*Math.min(height[left],height[right]);
            maxWater = Math.max(maxWater, currWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;

        // brute Force : O(n^2)
        // int n = height.length;
        // int max = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         max = Math.max(max , (j-i) * Math.min(height[i],height[j]));
        //     }
        // }
        // return max;
    
    }
}