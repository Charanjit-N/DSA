class Solution {
    // TC->O(2*arr.length) , SC->O(arr.length)
    int maxRectangleInHistogram(int arr[]){   
        int len = arr.length;
         Stack<Integer> st = new Stack<>();
         int pse = 0;
         int nse = 0;
         int ele_index = -1;
         int maxArea = 0;
         for(int i=0;i<len;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                ele_index = st.peek();
                st.pop();
                nse = i;
                pse =  st.isEmpty() ? -1 : st.peek();
                maxArea =  Math.max(maxArea , arr[ele_index]*(nse-pse-1));
            }
            st.push(i);
         }

         while(!st.isEmpty()){
            nse = len;
            ele_index = st.peek();
            st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea =  Math.max(maxArea , arr[ele_index]*(nse-pse-1));

         }
         return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        //Optimal :(Using Leetcode 84. Largest Rectangle in Histogram concept)
        // TC-> O(m * n) , SC-> O(n) 
        int m = matrix.length ;     // no.of rows
        int  n = matrix[0].length;  // no.of cols
        int maxArea = 0;
        int[] heights = new int[n];
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            int area =  maxRectangleInHistogram(heights);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}