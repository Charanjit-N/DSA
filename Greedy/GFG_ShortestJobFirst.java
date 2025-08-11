// TC->O(n*logn), SC->O(1)
class Solution {
    static int solve(int bt[]) {
        int n = bt.length;
        Arrays.sort(bt);
        int prefSum = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += prefSum;
            prefSum += bt[i];  
        }
        return sum/n;
    }
}
