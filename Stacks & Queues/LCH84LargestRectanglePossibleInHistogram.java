class LCH84LargestRectanglePossibleInHistogram {
    // int[] findNSE(int[] arr){
    //     Stack<Integer> st = new Stack<>();
    //     int n = arr.length;
    //     int[] nse = new int[n];
    //     for(int i=n-1;i>=0;i--){
    //         while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
    //             st.pop();
    //         }
    //         if(st.isEmpty()) nse[i] = n;
    //         else nse[i] = st.peek();
    //         st.push(i); 
    //     }
    //     return nse;
    // }
    // int[] findPSE(int[] arr){
    //     Stack<Integer> st = new Stack<>();
    //     int n = arr.length;
    //     int[] pse = new int[n];
    //     for(int i=0;i<n;i++){
    //         while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
    //             st.pop();
              
    //         }
    //         if(st.isEmpty()) pse[i] = -1;
    //         else pse[i] = st.peek();
    //         st.push(i); 
    //     }
    //     return pse;
    // }

    public int largestRectangleArea(int[] heights) {
         // Optimal : (No precomputation finding pse and nse arrays instead compute values while traversing )
         // TC->O(2N) , SC->O(N)     
         int n = heights.length;
         Stack<Integer> st = new Stack<>();
         int pse = 0;
         int nse = 0;
         int ele_index = -1;
         int maxArea = 0;
         for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                ele_index = st.peek();
                st.pop();
                nse = i;
                pse =  st.isEmpty() ? -1 : st.peek();
                maxArea =  Math.max(maxArea , heights[ele_index]*(nse-pse-1));
            }
            st.push(i);
         }

         while(!st.isEmpty()){
            nse = n;
            ele_index = st.peek();
            st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea =  Math.max(maxArea , heights[ele_index]*(nse-pse-1));

         }
         return maxArea;
           
        

        // Better (USing nse and pse concepts of monotonic stack)
        // TC->O(5n) , SC->O(4n)
        // int n = heights.length;
        // int[] nse = findNSE(heights);  // TC->O(2n) , SC->O(2n)
        // int[] pse = findPSE(heights);  // TC->O(2n) , SC->O(2n)
        // int maxArea = 0;

        // System.out.println(Arrays.toString(nse));
        // System.out.println(Arrays.toString(pse));
        // for(int i=0;i<n;i++){            // TC->O(n)
        //     maxArea = Math.max(maxArea, heights[i]*(nse[i]-pse[i]-1));
        // }
        // return maxArea;



        // Brute : TC->O(n^2) , SC->O(1)
        // int n = heights.length;
        // int maxArea = -1;
        // for(int i=0;i<n;i++){
        //     int num = heights[i];
        //     int maxCnt = -1;
        //     int cnt = 0;
        //     for(int j=0;j<n;j++){
        //         if(heights[j]>=num) cnt++;
        //         else{
        //             maxCnt = Math.max(maxCnt,cnt);
        //             cnt = 0;
        //         }
        //     }
        //     maxCnt = Math.max(maxCnt,cnt);
        //     int area =maxCnt * num;
        //     maxArea = Math.max(maxArea,area);

        // }
        // return maxArea;
        
    }
}