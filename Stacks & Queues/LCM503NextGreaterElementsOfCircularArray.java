class LCM503NextGreaterElementsOfCircularArray{
    public int[] LCM503NextGreaterElementsOfCircularArray(int[] nums) {
        /* Optimaml : TC->O(4n) , SC->O(2n) + O(n)  {this n is for returing the answer we cant optimise this space as the problem statement is demanding to return array.}
        */
        int n= nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if(i<n){
                nge[i] = (st.isEmpty() ? -1 : st.peek());
            }
            st.push(nums[i%n]);
        }
        return nge;
        
        //Brute :TC->O(n^2), SC->O(n) // this n is for returing the answer we cant optimise this space as the problem statement is demanding to return array.
        // int n = nums.length;
        // int[] nge = new int[n];
        // Arrays.fill(nge,-1);
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<(i+n);j++){
        //         if(nums[j%n]>nums[i]){
        //             nge[i] = nums[j%n];
        //             break;
        //         }
        //     }
        // }
        // return nge;
        
    }
}