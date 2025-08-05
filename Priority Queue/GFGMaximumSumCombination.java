//TC -> O(n*logn): sorting + O(k*logk) 
class Tuple{
    int sum;
    int i;
    int j;
    Tuple(int sum , int i, int j){
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> y.sum - x.sum);
        Set<String> vis = new HashSet<>();
        pq.add(new Tuple (a[n-1]+b[n-1], n-1, n-1));
        vis.add((n-1) + "," + (n-1));
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty() && k > 0){  // O(k*logk)
            Tuple t = pq.poll();
            int sum = t.sum;
            int i = t.i;
            int j = t.j;
            ans.add(sum);
            String nextPair1 = (i - 1) + "," + j;
            if(i - 1 >= 0 && !vis.contains(nextPair1)){
                pq.add(new Tuple(a[i-1]+b[j] , i-1,j));
                vis.add(nextPair1);
            }
            String nextPair2 = i + "," + (j - 1);
            if(j - 1 >= 0 && !vis.contains(nextPair2)){
                pq.add(new Tuple(a[i]+b[j-1] , i,j-1));
                vis.add(nextPair2);
            }
            k--;
        }
        return ans;
    }
}