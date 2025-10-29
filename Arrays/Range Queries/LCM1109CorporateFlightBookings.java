// TC -->O(N+Q), SC-->O(N)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr =  new int[n];
        for(int[] q :  bookings){
            if(q[0]-1>=0) arr[q[0]-1] += q[2];
            if(q[1] < n) arr[q[1]] -= q[2];
        }
        for(int i=1;i<n;i++){
            arr[i] += arr[i-1];
        }

        return arr;
        
    }
}