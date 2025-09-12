
// Using Greedy Approach : TC->O(n). SC->O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];
        for(char ch : tasks){
            freqMap[ch-'A']++;
        }
        // sort in descending order 
        Arrays.sort(freqMap);
        int left = 0, right = freqMap.length - 1;
        while (left < right) {
            int temp = freqMap[left];
            freqMap[left++] = freqMap[right];
            freqMap[right--] = temp;
        }

        int max = freqMap[0];   // we can also get max = freqMap[25] by just sorting in ascending and traverse from end
        int slots = max - 1;
        int spaces = slots * n;

        for(int i=1;i<26;i++){
            spaces -= Math.min(slots, freqMap[i]);
        }
        if(spaces > 0) return tasks.length + spaces;
        else return tasks.length;
    
    }
}


// Using priority queue TC->(approx)O(n), SC->O(n)
class LCM621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //max Heap
        int[] map = new int[26];
        for(char ch : tasks){
            map[ch-'A']++;
        }
        for(int f : map){
            if(f>0){
                pq.add(f);
            }
        }
        while(!pq.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int f : temp){
                if(f > 0){
                    pq.add(f);
                }
            }
            if(!pq.isEmpty()) time += (n+1);
            else time += temp.size();
        }
        return time;
    }
}
