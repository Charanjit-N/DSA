class LCE496NextGreaterElement{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /* Optimal : Using Monotonic Stack concept.
                   TC -> O(2(n2) + n1) = O(n1 + n2) (approximation)
                   SC -> O(2(n2) + n1) = O(n1 + n2) (approximation)  { In 2(n2) + n1 : one n2 is Stack , one n2 is for map and 
        n1 is by ans array and this n1 is for returing the answer we cant optimise this space as the problem statement is demanding to return array.
        If we neglect this space then SC->O(n2)}
        */
        Stack<Integer> st = new Stack<>();   
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=n2-1 ; i>=0 ; i--){               // Worst case TC->O(2(n2))
            while(!st.isEmpty() && st.peek()<=nums2[i]){     
                st.pop();
            }
            if(st.isEmpty()) map.put(nums2[i],-1);
            else map.put(nums2[i],st.peek()); 
            st.push(nums2[i]);
        }
        // System.out.println(map);
        for(int i=0;i<n1;i++){                    // TC->O(n1)
            ans[i] = map.get(nums1[i]);
        }
        return ans;

        
        //Brute :TC->O(n1 * n2), SC->O(n1) // n1 is for returing the answerwe cant optimise this space as the problem statement is demanding to return array.
        // int n1 = nums1.length;
        // int n2 =nums2.length;
        // int[] ans = new int[n1];
        // boolean caught = false;
        // for(int i=0;i<n1;i++){
        //     caught = false;
        //     for(int j=0;j<n2;j++){
        //         if(nums1[i]==nums2[j]) caught = true;
        //         if(nums2[j]>nums1[i] && caught == true){
        //             ans[i] = nums2[j];
        //             break;
        //         }
        //     }
        //     if(ans[i]==0) ans[i]=-1;
        // }
        // return ans;
        
    }
}