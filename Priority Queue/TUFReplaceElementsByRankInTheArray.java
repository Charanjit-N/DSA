// TC-->O(n^2) , SC->O(n)
class Solution{
    void replaceByRank(int[] arr){
        int n = arr.length;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) {
                s.add(arr[j]);
                }
            }
            rank[i] = s.size() + 1;
        }
        for(int i=0;i<n;i++){
            arr[i] =  rank[i];
        }
    }
}

// Optimal solutions:
// TC-->O(n) + O(n logn) + O(n) --> O(nlogn) , SC->O(n)
class Solution{
    void replaceByRank(int[] arr){
        int n = arr.length;
        int[] arrCopy = new int[n];
        for(int i=0;i<n;i++){
            arrCopy[i] = arr[i];
        }
        Arrays.sort(arrCopy);
        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 1;
        for (int i = 0; i < n; i++) {
            if(!map.containsKey((Integer)arrCopy[i])){
                map.put(arrCopy[i],r);
                r++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }

    }
}
// TC-->O(n) + O(n logn) + O(n) --> O(nlogn) , SC->O(n)
class Solution{
    void replaceByRank(int[] arr){
        int n = arr.length;
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 1;
        while(!pq.isEmpty()) {
            int val =  pq.poll();
            if(!map.containsKey((Integer)val)){
                map.put(val,r);
                r++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }
    }
}