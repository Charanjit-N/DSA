// SC -> O(k)
class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
    
    // TC --> O(n * logK) n : nums.length
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }  
    }    
    // TC ->O(log K)
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
