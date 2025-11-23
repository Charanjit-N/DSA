// Optimal : greey approach
// TC ->O(n logn)
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });
        int p1 = -1, p2 = -1;
        int count = 0;
        for (int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];
            int inside = 0;
            if (p1 >= s) inside++;
            if (p2 >= s) inside++;
            if (inside == 2) {
                continue; 
            } else if (inside == 1) {
                count++;
                if (p1 < s) {
                    
                    p1 = p2;
                    p2 = e;
                } else {
                  
                    p2 = e;
                }
            } else {
                
                count += 2;
                p1 = e - 1;
                p2 = e;
            }
        }
        return count;
    }
}