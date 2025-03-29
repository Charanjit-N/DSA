class LCH42TrappingRainWater {
    public int trap(int[] height) {
        // Optimal (Two pointer technique) : TC->O(n) , SC->O(1)
        // At the end the 'l' and 'r' pointers will meet at the max element in the height array.
        int n = height.length;
        int l = 0, r = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        while(l <  r){
            if(height[l] <= height[r]){
                if(leftMax > height[l]){
                    total += leftMax - height[l];
                }
                else{
                    leftMax = height[l];
                }
                l++;
            }
            else{
                if(rightMax > height[r]){
                    total += rightMax - height[r];
                }
                else{
                    rightMax = height[r];
                }
                r--;
            }
        }
        return total;



        // Better 2 :  (Littile Optimization on Better 1) : We keep track of leftMax (prefix Maximum) while Iteration
        // TC -> O(2n) , SC->(n)

        // int n = height.length;
        // int suffixMax[] = new int[n];
        // suffixMax[n-1] = height[n-1];
        // for(int i=n-2;i>=0;i--){
        //     suffixMax[i] = Math.max(suffixMax[i+1],height[i]);
        // }

        // int total = 0;
        // int leftMax = height[0];
        // for(int i=0;i<n;i++){
        //     if(i>0) leftMax = Math.max(height[i-1],leftMax);
        //     int rightMax = suffixMax[i];
        //     if(leftMax>height[i] && rightMax>height[i]){
        //         total  = total + (Math.min(leftMax,rightMax) - height[i]);
        //     }
        // }
        // return total;




        // Better 1 :  (prefix and siffix Concept): TC->O(3n) , SC->(2n)
        // int n = height.length;
        // int prefixMax[] = new int[n];
        // int suffixMax[] = new int[n];

        // prefixMax[0] = height[0];
        // for(int i=1;i<n;i++){
        //     prefixMax[i] = Math.max(prefixMax[i-1],height[i]);
        // }

        // suffixMax[n-1] = height[n-1];
        // for(int i=n-2;i>=0;i--){
        //     suffixMax[i] = Math.max(suffixMax[i+1],height[i]);
        // }

        // System.out.println(Arrays.toString(prefixMax));
        // System.out.println(Arrays.toString(suffixMax));

        // int total = 0;
        // for(int i=0;i<n;i++){
        //     int leftMax = prefixMax[i];
        //     int rightMax = suffixMax[i];
        //     if(leftMax>height[i] && rightMax>height[i]){
        //         total  = total + (Math.min(leftMax,rightMax) - height[i]);
        //     }
        // }
        // return total;

        
    }
}