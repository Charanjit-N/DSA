// TC=>O(N), SC=>O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total +=  gas[i] - cost[i];
        }
        if(total < 0 ) return -1;

        int sum = 0;
        int start = 0;       
        for(int i=0;i<n;i++){
            int diff =  gas[i] - cost[i];
            sum += diff;
            if(sum < 0){
                sum = 0;
                start = i+1;
            }
        }
        return start;
    }
}