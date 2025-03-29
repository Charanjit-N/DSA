class LCM907SumOfMinimumsOfAllSubArrays {
    
    int[] findNSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i); 
        }
        return nse;
    }
    int[] findPSEE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] psee = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()) psee[i] = -1;
            else psee[i] = st.peek();
            st.push(i); 
        }
        return psee;
    }
    public int sumSubarrayMins(int[] arr) {
        // Optimal (Monotonic Stack) : TC->O(5n)=O(n)(approx) , SC->O(4n)=O(n)(approx)
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        int total =0;
        int modVal = (int)(1e9+7);
        for(int i=0;i<n;i++){
            int left = i-psee[i];
            int  right = nse[i] - i;
            total = (int)(total + (1L*right*left*arr[i])%modVal) % modVal;
        }
        return total;

        // Better : TC->O(n^2) , SC->O(1)
        // int n = arr.length;
        // int modVal = (int)(1e9 + 7);
        // int sum = 0;
        // for(int i=0;i<n;i++){
        //     int min = Integer.MAX_VALUE;
        //     for(int j=i;j<n;j++){
        //         min = Math.min(arr[j],min);
        //         sum = (sum+min)%modVal;
        //     }
        // }
        // return sum;

        //Brute : Finding minimums and summing for all the subarrays  
        // TC->O(n^3) , SC->O(1)
        // int n = arr.length;
        // int modVal = (int)(1e9 + 7);
        // int sum = 0;
        // for(int i=0;i<n;i++){
            
        //     for(int j=i;j<n;j++){
        //         int min = Integer.MAX_VALUE;
        //         for(int k=i;k<=j;k++){
        //             min = Math.min(arr[k],min);
        //         }
        //         sum = (sum+min)%modVal;
        //     }
        // }
        // return sum;   
        
    }
}