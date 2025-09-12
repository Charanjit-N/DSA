// using Priority Queue and hash map 
// TC-->O(n * logn) , SC->O(n)
class Pair{
    int freq;
    int val;    
    Pair(int freq, int val){
        this.freq = freq;
        this.val = val;
        
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(                   (x,y)->y.freq-x.freq);

        for(Map.Entry<Integer, Integer> x : map.entrySet()){
            pq.add(new Pair(x.getValue(),x.getKey()));
        }
        int[] ans = new int[k];
        int index=0;
        while(k>0){
            ans[index++] = pq.poll().val;
            k--;
        }
        return ans;
    }
}


// TC ->O(n), SC->O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer>[] freq = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            freq[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            freq[x.getValue()].add(x.getKey());
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i = n; i >= 0; i--) {
            for (Integer x : freq[i]) {
                ans[index++] = (int) x;
                if (index == k) return ans;
            }
        }
        return ans;
    }
}

