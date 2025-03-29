class LCM2104SumOfRangesOfAllSubArrays {
    int[] findNGE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) nge[i] = n;
            else nge[i] = st.peek();
            st.push(i); 
        }
        return nge;
    }
    int[] findPGEE(int[] arr){       //previous greater or elqual element
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pgee = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.isEmpty()) pgee[i] = -1;
            else pgee[i] = st.peek();
            st.push(i); 
        }
        return pgee;
    }
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
    int[] findPSEE(int[] arr){     //previous smaller or elqual element
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
    public long subArrayRanges(int[] nums) {
        // Optimal (using Monotonic Stack appplications) : TC->O(9N) = O(N) (approx) , SC->O(8N) =O(N) (approx)
        int n = nums.length;
        int[] nse = findNSE(nums);    // TC->O(2N) , SC->O(2N)
        int[] psee = findPSEE(nums);   // TC->O(2N) , SC->O(2N)
        int[] nge = findNGE(nums);    // TC->O(2N) , SC->O(2N)
        int[] pgee = findPGEE(nums);   // TC->O(2N) , SC->O(2N)

        long sumOfMin =0;
        long sumOfMax =0;
        long sum = 0;
        
        for(int i=0;i<n;i++){       // TC->O(N)
            int leftForMin = i-psee[i];
            int  rightForMin = nse[i] - i;
            int leftForMax = i-pgee[i];
            int  rightForMax = nge[i] - i;
            sumOfMin = sumOfMin + (1L*rightForMin*leftForMin*nums[i]);
            sumOfMax = sumOfMax + (1L*rightForMax*leftForMax*nums[i]);
        }
        sum = sumOfMax - sumOfMin;
        return sum;

        // Better : TC->O(n^2) , SC->O(1)
        // int n = nums.length;
        // long sum = 0;
        // for(int i=0;i<n;i++){
        //     int min = Integer.MAX_VALUE;
        //     int max = Integer.MIN_VALUE;
        //     for(int j=i;j<n;j++){
        //         min = Math.min(nums[j],min);
        //         max = Math.max(nums[j],max);
        //         sum = (sum+(max-min));
        //     }
        // }
        // return sum;


        //Brute : Finding ranges(max - min) and summing for all the subarrays  
        // TC->O(n^3) , SC->O(1)
        // int n = nums.length;
        // long sum = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int min = Integer.MAX_VALUE;
        //         int max = Integer.MIN_VALUE;
        //         for(int k=i;k<=j;k++){
        //             min = Math.min(nums[k],min);
        //             max = Math.max(nums[k],max);
        //         }
        //         sum = (sum+(max-min));
        //     }
        // }
        // return sum;   
    }
}