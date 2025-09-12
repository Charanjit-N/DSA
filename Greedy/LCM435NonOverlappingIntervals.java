// TC->O(n*logn), SC->O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(x,y) -> x[1]-y[1]);
        int prevEnd = intervals[0][1];
        int cnt =1;
        for(int i=1;i<n;i++){
            int curStart = intervals[i][0];
            if(curStart >= prevEnd){
                cnt++;
                prevEnd = intervals[i][1];
            }
        }
        return n - cnt;
    }
}


// TC->O(n*logn), SC->O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prev_end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prev_end > intervals[i][0]) {
                res++;
            } else {
                prev_end = intervals[i][1];
            }
        }
        return res;        
    }
}