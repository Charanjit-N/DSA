// TC-->O(n*logn) , SC->O(n)
class Pair{
    int val;
    int freq;
    Pair(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
}
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n%k != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.val - y.val);
        
        for (Map.Entry<Integer,Integer> i : map.entrySet()){
            pq.add(new Pair(i.getKey(),i.getValue()));

        } 
        while(!pq.isEmpty()){
            int prev = -1;
            ArrayList<Pair> ls = new ArrayList<>();
            for(int i=0;i<k;i++){
                if(pq.isEmpty()) return false;
                Pair p = pq.poll();
                int val = p.val;
                int freq =  p.freq;
                if(prev == -1 || val == prev+1){
                    freq--;
                    ls.add(new Pair(val, freq));
                    prev = val;
                }
                else return false;
            }
            for(Pair pp :  ls){
                if(pp.freq>0) pq.add(pp);
            }
        }
        return true;
    }
}


// TC->O(n * logn) {treemap add, remove operations : logn}, SC->O(n)
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i=0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        while (!map.isEmpty()) {
            int start = map.firstKey();
            
            for (int i = 0; i < k; i++) {
                int curr = start + i;
                if (!map.containsKey(curr)) {
                    return false;
                }
                int cnt = map.get(curr);
                if (cnt == 1) {
                    map.remove(curr);
                } else {
                    map.put(curr, cnt - 1);
                }
            }
        }
        return true;
    }
}



// TC-> O(n^2) worst case , SC-->O(1)
class Solution {
    public boolean findsucessors(int[] nums,int i , int k) {
        int next = nums[i] + 1;
        nums[i] = -1;
        int cnt = 1;
        i += 1;
        while (i < nums.length && cnt < k) {
            if (nums[i] == next) {
                next = nums[i] + 1;
                nums[i] = -1;
                cnt++;
            }
            i++;
        }
        if (cnt != k)
            return false;
        else
            return true;
    }
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        Arrays.sort(nums);
        for (int i= 0; i < n; i++) {
            if (nums[i] >= 0) {
                if (!findsucessors(nums, i, k)){
                    return false;
                }
            }
        }
        return true;
    }
}