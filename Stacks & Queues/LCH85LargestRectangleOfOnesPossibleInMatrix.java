class LCH85LargestRectangleOfOnesPossibleInMatrix {
    int maxRectangleInHistogram(int arr[]){   // TC->O(2*len) , SC->O(len)
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
        /*Optimal :(Using Leetcode 84. Largest Rectangle in Histogram concept)
          TC-> O(m * n) +  O(m * 2n)  = O(m * n)(aprox)
          SC-> O(m * n) + O(n) = O(m * n) (approx)  { Used another matrix(prefixSum) to store values instead we 
          can change the given input but not advisable to tamper the input in practice}
        */

        // precomputing the prefixsum 2D array
        int m = matrix.length ;     // no.of rows
        int  n = matrix[0].length;  // no.of cols
        int[][] prefixSum = new int[m][n];
        for(int j=0;j<n;j++){                // O(m * n)
            int sum = 0;
            for(int i=0;i<m;i++){
                sum += (matrix[i][j]-'0');
                if(matrix[i][j]=='0') sum =0;
                prefixSum[i][j] = sum;
            }
        }

        int maxArea = 0;
        for(int i=0;i<m;i++){     // TC->O(m * 2n)
            maxArea = Math.max(maxArea,maxRectangleInHistogram(prefixSum[i]));
        }
        return maxArea;
        
    }
}