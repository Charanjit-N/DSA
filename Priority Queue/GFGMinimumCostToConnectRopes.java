// TC->O(n * logn), SC->O(n)
class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : arr){
            pq.add(x);
        }
        int totoalCost = 0;
        while(pq.size()>1){
            int cost = 0;
            cost +=pq.poll();
            cost+=pq.poll();
            totoalCost += cost;
            pq.add(cost);
        }
        return totoalCost;
        
    }
}

