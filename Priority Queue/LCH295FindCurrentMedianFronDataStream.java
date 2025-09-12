
// Brute Force : TLE 
class MedianFinder {
    PriorityQueue<Integer> pq;
    public MedianFinder() {
        pq=  new PriorityQueue<>();
        
    }
    public void addNum(int num) {
         pq.add(num);
    }
    public double findMedian() {
        ArrayList<Integer> ls = new ArrayList<>();
        int size =  pq.size();
        int k =  size/2;
        for(int i=1;i<=k-1;i++){
            ls.add(pq.poll());
        }
        double ans = 0;
        if(size %2==0){
            int a = pq.poll();
            ls.add(a);
            int b = pq.poll();
            ls.add(b);
             ans = ((double)a + b )/ 2;
        }
        else{
            if(pq.size()==1) return pq.peek();
            int a = pq.poll();
            ls.add(a);
            ans =  (double)pq.peek();
        }
        for(int i=0;i<ls.size();i++){
            pq.add(ls.get(i));
        }
        return ans;
    }
}


class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap=  new PriorityQueue<>((x,y) -> y-x);
        minHeap = new PriorityQueue<>();
    }
    // TC ->O(log N)
    public void addNum(int num) {
         maxHeap.add(num);
         if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
         }
         if(maxHeap.size()>0 && minHeap.size() > 0  &&               maxHeap.peek() > minHeap.peek()){
            minHeap.add(maxHeap.poll());
            if(minHeap.size() >  maxHeap.size()+1){
                maxHeap.add(minHeap.poll());
            }
         }
    }
    // TC->O(1)
    public double findMedian() {
        int a = maxHeap.size();
        int b = minHeap.size();
        if((a+b) % 2 == 0) return ((double)maxHeap.peek() +            minHeap.peek())/2;
        else{
            if(a > b) return maxHeap.peek();
            else return minHeap.peek();
        }
    }
}