import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Optimal (Using monotonic Dequeue)
        // TC->O(2n) , SC->O(k)+O(n-k+1) { O(k)->Deque , O(n-k+1)->to return the answer not used to solve the problem}
        int n = nums.length;
        int ans[] = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i>=k-1) ans[i-k+1] = nums[dq.peekFirst()];
        }
        return ans;


        //Brute Force : (TLE) TC->O((n-k) * k) , SC->O(n-k+1) {to return the answer}
        // int n = nums.length;
        // int[] ans = new int[n-k+1];
        // for(int i=0;i<=n-k;i++){
        //     int max = Integer.MIN_VALUE;
        //     for(int j=i;j<i+k;j++){
        //         max = Math.max(nums[j],max);
        //     }
        //     ans[i] = max;
        // }
        // return ans;

        
    }
}