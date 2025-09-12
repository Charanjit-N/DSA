// TC-->O(N logN)
class Solution {
    public int findKthSmallest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->x-y);
        for(int i=0;i<n;i++){
            pq.add(nums[i]);   // log(# elements in pq at that time)
        }
        for(int i=1;i<=k-1;i++){
            pq.poll();   //log(# elements in pq at that time)
        }
        return pq.peek();
    }
}